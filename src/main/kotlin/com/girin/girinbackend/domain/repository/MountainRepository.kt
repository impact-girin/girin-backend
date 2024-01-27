package com.girin.girinbackend.domain.repository

import com.girin.girinbackend.domain.entity.building.Mountain
import org.springframework.data.repository.CrudRepository

interface MountainRepository : CrudRepository<Mountain, Long> {
    fun findAllByName(name: String): List<Mountain>
}
