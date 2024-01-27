package com.girin.girinbackend.domain.service

import com.girin.girinbackend.domain.controller.dto.response.RestaurantList
import com.girin.girinbackend.domain.repository.MountainRepository
import com.girin.girinbackend.domain.repository.RestaurantRepository
import org.springframework.stereotype.Service

@Service
class RestaurantService(
    private val restaurantRepository: RestaurantRepository,
    private val mountainRepository: MountainRepository,
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
            )
        }

        return RestaurantList(response)
    }
}
