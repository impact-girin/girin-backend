package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.domain.controller.dto.request.CreateFeedRequest
import com.girin.girinbackend.domain.service.SocialService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/feed")
@RestController
class FeedController(
    private val socialService: SocialService,
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody request: CreateFeedRequest) {
        socialService.createFeed(request)
    }
}
