package com.girin.girinbackend.domain.repository

import com.girin.girinbackend.domain.entity.club.ParticipateMountainClub
import com.girin.girinbackend.domain.entity.user.User
import org.springframework.data.repository.CrudRepository

interface ParticipateMountainClubRepository : CrudRepository<ParticipateMountainClub, Long> {
    fun existsByUser(user: User): Boolean
}
