package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.domain.controller.dto.request.CreateMountainClubRequest
import com.girin.girinbackend.domain.service.MountainClubService
import org.springframework.http.HttpStatus
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
}
