package com.girin.girinbackend.domain.service

import com.girin.girinbackend.domain.controller.dto.response.MountainList
import com.girin.girinbackend.domain.repository.MountainRepository
import org.springframework.stereotype.Service

@Service
class MountainService(
    private val mountainRepository: MountainRepository,
) {

    fun getMountainList(): MountainList {
        val mountainList = mountainRepository.findAll()

        val response = mountainList.map { mountain ->
            MountainList.MountainElement(
                mountainId = mountain.id,
                latitude = mountain.latitude,
                longitude = mountain.longitude,
                name = mountain.name,
                height = mountain.height,
                detailInfo = mountain.detailInfo,
                mountainImageUrl = mountain.mountainImageUrl,
            )
        }

        return MountainList(response)
    }

    fun getMountainByName(name: String): MountainList.MountainElement {
        val mountain = mountainRepository.findByName(name)

        return MountainList.MountainElement(
            mountainId = mountain.id,
            latitude = mountain.latitude,
            longitude = mountain.longitude,
            name = mountain.name,
            height = mountain.height,
            detailInfo = mountain.detailInfo,
            mountainImageUrl = mountain.mountainImageUrl,
        )
    }
}
