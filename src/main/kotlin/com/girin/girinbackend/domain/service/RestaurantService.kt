package com.girin.girinbackend.domain.service

import com.girin.girinbackend.common.exception.RestaurantNotFoundException
import com.girin.girinbackend.domain.controller.dto.response.OneRestaurantElement
import com.girin.girinbackend.domain.controller.dto.response.RestaurantList
import com.girin.girinbackend.domain.repository.MenuRepository
import com.girin.girinbackend.domain.repository.MountainRepository
import com.girin.girinbackend.domain.repository.RestaurantRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalTime

@Service
class RestaurantService(
    private val restaurantRepository: RestaurantRepository,
    private val mountainRepository: MountainRepository,
    private val menuRepository: MenuRepository,
) {

    fun getRestaurantListNearMountain(name: String): RestaurantList {
        val mountainId = mountainRepository.findByName(name).id
        val restaurantList = restaurantRepository.findAllByMountainId(mountainId)

        val response = restaurantList.map { restaurant ->
            RestaurantList.RestaurantElement(
                restaurantId = restaurant.id,
                mountainId = restaurant.mountain.id,
                name = restaurant.name,
                latitude = restaurant.latitude,
                longitude = restaurant.longitude,
                restaurantImageUrl = restaurant.restaurantImageUrl,
                restaurantAddress = restaurant.address,
            )
        }

        return RestaurantList(response)
    }

    fun getAllRestaurant(): RestaurantList {
        val restaurantList = restaurantRepository.findAll()

        val response = restaurantList.map { restaurant ->
            RestaurantList.RestaurantElement(
                restaurantId = restaurant.id,
                mountainId = restaurant.mountain.id,
                name = restaurant.name,
                latitude = restaurant.latitude,
                longitude = restaurant.longitude,
                restaurantImageUrl = restaurant.restaurantImageUrl,
                restaurantAddress = restaurant.address,
            )
        }

        return RestaurantList(response)
    }

    fun getRestaurantDetailById(restaurantId: Long): OneRestaurantElement {
        val restaurant = restaurantRepository.findByIdOrNull(restaurantId)
            ?: throw RestaurantNotFoundException

        val menuList = menuRepository.findAllByRestaurantId(restaurant.id)
        var isUseAvailable = true
        if (LocalTime.now() > restaurant.endTime || restaurant.startTime > LocalTime.now()) {
            isUseAvailable = false
        }

        return OneRestaurantElement(
            restaurantId = restaurant.id,
            mountainId = restaurant.mountain.id,
            name = restaurant.name,
            latitude = restaurant.latitude,
            longitude = restaurant.longitude,
            restaurantAddress = restaurant.address,
            restaurantImageUrl = restaurant.restaurantImageUrl,
            reviewScore = restaurant.reviewScore,
            reviewCount = restaurant.reviewCount,
            startTime = restaurant.startTime,
            endTime = restaurant.endTime,
            isUseAvailable = isUseAvailable,
            menuList = menuList.map { menu ->
                OneRestaurantElement.MenuElement(
                    menuId = menu.id,
                    menuName = menu.name,
                    menuEngName = menu.menuInfo,
                    menuImageUrl = menu.menuImageUrl,
                    menuPrice = menu.menuPrice,
                )
            }
        )
    }
}
