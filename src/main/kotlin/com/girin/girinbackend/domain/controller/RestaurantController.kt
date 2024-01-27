package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.domain.controller.dto.response.RestaurantList
import com.girin.girinbackend.domain.service.RestaurantService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/restaurant")
@RestController
class RestaurantController(
    private val restaurantService: RestaurantService,
) {

    @GetMapping("/list")
    fun getRestaurantList(): RestaurantList {
        return restaurantService.getRestaurantList()
    }
}
