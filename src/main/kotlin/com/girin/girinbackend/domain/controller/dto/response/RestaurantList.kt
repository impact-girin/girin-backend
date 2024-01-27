package com.girin.girinbackend.domain.controller.dto.response

data class RestaurantList(
    val restaurantList: List<RestaurantElement>,
) {
    data class RestaurantElement(
        val restaurantId: Long,
        val name: String,
        val latitude: Double,
        val longitude: Double,
        val restaurantImageUrl: String,
    )
}
