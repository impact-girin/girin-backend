package com.girin.girinbackend.domain.repository

import com.girin.girinbackend.domain.entity.social.Feed
import org.springframework.data.repository.CrudRepository

interface FeedRepository : CrudRepository<Feed, Long>
