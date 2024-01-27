package com.girin.girinbackend.domain.controller.dto.request

data class UserSignInRequest(
    val phoneNumber: String,
    val password: String,
)
