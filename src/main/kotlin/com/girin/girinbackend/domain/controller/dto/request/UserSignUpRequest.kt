package com.girin.girinbackend.domain.controller.dto.request

data class UserSignUpRequest(
    val phoneNumber: String,
    val password: String,
    val age: String,
    val zone: String,
    val name: String,
)
