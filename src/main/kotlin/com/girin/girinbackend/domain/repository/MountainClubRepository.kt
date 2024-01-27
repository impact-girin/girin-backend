package com.girin.girinbackend.domain.repository

import com.girin.girinbackend.domain.entity.club.MountainClub
import org.springframework.data.repository.CrudRepository

interface MountainClubRepository : CrudRepository<MountainClub, Long>
