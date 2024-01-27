package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.common.security.jwt.TokenResponse
import com.girin.girinbackend.domain.controller.dto.request.UserSignInRequest
import com.girin.girinbackend.domain.controller.dto.request.UserSignUpRequest
import com.girin.girinbackend.domain.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val userService: UserService,
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signUp")
    fun signUp(@RequestBody request: UserSignUpRequest): TokenResponse {
        return userService.signUp(request)
    }

    @PostMapping("/signIn")
    fun signIn(@RequestBody request: UserSignInRequest): TokenResponse {
        return userService.signIn(request)
    }
}
