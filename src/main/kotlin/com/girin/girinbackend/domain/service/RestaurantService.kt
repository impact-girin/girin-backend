package com.girin.girinbackend.domain.service

import com.girin.girinbackend.domain.controller.dto.response.RestaurantList
import com.girin.girinbackend.domain.repository.RestaurantRepository
import org.springframework.stereotype.Service

@Service
class RestaurantService(
    private val restaurantRepository: RestaurantRepository,
) {

    fun getRestaurantList(): RestaurantList {
        val restaurant = restaurantRepository.findAll()

        val response = restaurant.map { restaurant ->
            RestaurantList.RestaurantElement(
                restaurantId = restaurant.id,
                name = restaurant.name,
                latitude = restaurant.latitude,
                longitude = restaurant.longitude,
                restaurantImageUrl = restaurant.restaurantImageUrl,
            )
        }

        return RestaurantList(response)
    }
}
