package com.girin.girinbackend.domain.controller.dto.request

data class CreateMountainClubRequest(
    val name: String,
    val zone: String,
    val age: String,
    val introduce: String,
    val maxPeople: Int,
    val mountainClubImageUrl: String,
    val contactLink: String,
    val mountainId: Long,
)
