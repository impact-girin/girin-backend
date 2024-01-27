package com.girin.girinbackend.domain.service

import com.girin.girinbackend.common.exception.AlreadyParticipateException
import com.girin.girinbackend.common.exception.MountainClubNotFoundException
import com.girin.girinbackend.common.exception.MountainNotFoundException
import com.girin.girinbackend.domain.controller.dto.request.CreateMountainClubRequest
import com.girin.girinbackend.domain.controller.dto.response.MountainClubList
import com.girin.girinbackend.domain.controller.dto.response.OneMountainClubElement
import com.girin.girinbackend.domain.entity.club.MountainClub
import com.girin.girinbackend.domain.facade.UserFacade
import com.girin.girinbackend.domain.repository.MountainClubRepository
import com.girin.girinbackend.domain.repository.MountainRepository
import com.girin.girinbackend.domain.repository.ParticipateMountainClubRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MountainClubService(
    private val mountainClubRepository: MountainClubRepository,
    private val participateMountainClubRepository: ParticipateMountainClubRepository,
    private val mountainRepository: MountainRepository,
    private val userFacade: UserFacade,
) {

    fun createMountainClub(request: CreateMountainClubRequest) {
        val currentUser = userFacade.getCurrentUser()
        val mountain = mountainRepository.findByIdOrNull(request.mountainId)
            ?: throw MountainClubNotFoundException

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
                contactLink = request.contactLink,
                headUser = currentUser,
                mountain = mountain,
            )
        )
    }

    fun getMountainClubList(): MountainClubList {
        val mountainClubList = mountainClubRepository.findAll()

        val response = mountainClubList.map { mountainClub ->
            MountainClubList.MountainClubElement(
                mountainClubId = mountainClub.id,
                clubName = mountainClub.name,
                zone = mountainClub.zone,
                maxPeople = mountainClub.maxPeople,
                introduce = mountainClub.introduce,
                mountainClubImageUrl = mountainClub.mountainClubImageUrl,
                contactLink = mountainClub.contactLink,
            )
        }

        return MountainClubList(response)
    }

    fun getMountainClubById(mountainClubId: Long): OneMountainClubElement {
        val mountainClub = mountainClubRepository.findByIdOrNull(mountainClubId)
            ?: throw MountainClubNotFoundException

        val mountain = mountainRepository.findByIdOrNull(mountainClub.mountain.id)
            ?: throw MountainNotFoundException

        return OneMountainClubElement(
            mountainClubId = mountainClub.id,
            clubName = mountainClub.name,
            zone = mountainClub.zone,
            currentPeople = participateMountainClubRepository.countByMountainClub(mountainClub),
            introduce = mountainClub.introduce,
            mountainClubImageUrl = mountainClub.mountainClubImageUrl,
            contactLink = mountainClub.contactLink,
            mountainInfo = OneMountainClubElement.MountainInfo(
                height = mountain.height,
                detailInfo = mountain.detailInfo,
            )
        )
    }
}
