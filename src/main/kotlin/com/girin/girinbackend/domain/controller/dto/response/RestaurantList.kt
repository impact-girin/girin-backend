package com.girin.girinbackend.domain.controller.dto.response

import java.time.LocalTime

data class RestaurantList(
    val restaurantList: List<RestaurantElement>,
) {
    data class RestaurantElement(
        val restaurantId: Long,
        val mountainId: Long,
        val name: String,
        val latitude: Double,
        val longitude: Double,
        val restaurantImageUrl: String,
    )
}

data class OneRestaurantElement(
    val restaurantId: Long,
    val mountainId: Long,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val restaurantImageUrl: String,
    val reviewScore: Double,
    val reviewCount: Int,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val isUseAvailable: Boolean,
    val menuList: List<MenuElement>,
) {
    data class MenuElement(
        val menuId: Long,
        val menuName: String,
        val menuEngName: String,
        val menuImageUrl: String,
        val menuPrice: Long,
    )
}
