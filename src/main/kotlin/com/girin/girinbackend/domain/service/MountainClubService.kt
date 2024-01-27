package com.girin.girinbackend.domain.service

import com.girin.girinbackend.common.exception.AlreadyParticipateException
import com.girin.girinbackend.domain.controller.dto.request.CreateMountainClubRequest
import com.girin.girinbackend.domain.entity.club.MountainClub
import com.girin.girinbackend.domain.facade.UserFacade
import com.girin.girinbackend.domain.repository.MountainClubRepository
import com.girin.girinbackend.domain.repository.ParticipateMountainClubRepository
import org.springframework.stereotype.Service

@Service
class MountainClubService(
    private val mountainClubRepository: MountainClubRepository,
    private val participateMountainClubRepository: ParticipateMountainClubRepository,
    private val userFacade: UserFacade,
) {

    fun createMountainClub(request: CreateMountainClubRequest) {
        val currentUser = userFacade.getCurrentUser()

        if (participateMountainClubRepository.existsByUser(currentUser)) {
            throw AlreadyParticipateException
        }

        mountainClubRepository.save(
            MountainClub(
                name = request.name,
                zone = request.zone,
                age = request.age,
                introduce = request.introduce,
                maxPeople = request.maxPeople,
                mountainClubImageUrl = request.mountainClubImageUrl,
                headUser = currentUser,
            )
        )
    }

    // TODO: 1/27 20시 디자인 안 나와서 feign 쪽 먼저 처리
//    fun getMountainClubList(targetZone: String)
}
