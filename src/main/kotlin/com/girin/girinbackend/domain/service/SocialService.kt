package com.girin.girinbackend.domain.service

import com.girin.girinbackend.domain.controller.dto.request.CreateFeedRequest
import com.girin.girinbackend.domain.entity.social.Feed
import com.girin.girinbackend.domain.facade.UserFacade
import com.girin.girinbackend.domain.repository.FeedRepository
import org.springframework.stereotype.Service

@Service
class SocialService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
) {
    fun createFeed(request: CreateFeedRequest) {
        feedRepository.save(
            Feed(
                content = request.content,
                feedImageUrl = request.feedImageUrl,
                user = userFacade.getCurrentUser(),
            )
        )
    }
}
