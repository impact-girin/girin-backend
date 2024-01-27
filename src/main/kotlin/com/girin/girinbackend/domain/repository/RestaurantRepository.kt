package com.girin.girinbackend.domain.repository

import com.girin.girinbackend.domain.entity.building.Restaurant
import org.springframework.data.repository.CrudRepository

interface RestaurantRepository : CrudRepository<Restaurant, Long> {
    fun findAllByMountainId(mountainId: Long): List<Restaurant>
}
