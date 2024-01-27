package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.domain.controller.dto.request.CreateMountainClubRequest
import com.girin.girinbackend.domain.controller.dto.response.MountainClubList
import com.girin.girinbackend.domain.controller.dto.response.OneMountainClubElement
import com.girin.girinbackend.domain.service.MountainClubService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/mountainClub")
@RestController
class MountainClubController(
    private val mountainClubService: MountainClubService,
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createMountainClub(@RequestBody request: CreateMountainClubRequest) {
        mountainClubService.createMountainClub(request)
    }

    @PostMapping("/in/{mountain-club-id}")
    fun participatedInMountainClub(
        @PathVariable("mountain-club-id") mountainClubId: Long,
    ) {
        mountainClubService.participatedInMountainClub(mountainClubId)
    }

    @GetMapping("/list")
    fun getMountainClubList(): MountainClubList {
        return mountainClubService.getMountainClubList()
    }

    @GetMapping("/{mountain-club-id}")
    fun getMountainClubById(
        @PathVariable("mountain-club-id") mountainClubId: Long
    ): OneMountainClubElement {
        return mountainClubService.getMountainClubById(mountainClubId)
    }
}
