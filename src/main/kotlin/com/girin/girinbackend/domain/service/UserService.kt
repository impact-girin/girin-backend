package com.girin.girinbackend.domain.service

import com.girin.girinbackend.common.exception.UserExistException
import com.girin.girinbackend.common.exception.UserNotFoundException
import com.girin.girinbackend.common.exception.UserPasswordMisMatchException
import com.girin.girinbackend.common.security.jwt.JwtProvider
import com.girin.girinbackend.common.security.jwt.TokenResponse
import com.girin.girinbackend.domain.controller.dto.request.UserSignInRequest
import com.girin.girinbackend.domain.controller.dto.request.UserSignUpRequest
import com.girin.girinbackend.domain.controller.dto.response.MyInfoElement
import com.girin.girinbackend.domain.entity.user.User
import com.girin.girinbackend.domain.facade.UserFacade
import com.girin.girinbackend.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userFacade: UserFacade,
    private val jwtProvider: JwtProvider,
) {

    fun signUp(request: UserSignUpRequest): TokenResponse {
        if (userRepository.existsByPhoneNumber(request.phoneNumber)) {
            throw UserExistException
        }

        userRepository.save(
            User(
                phoneNumber = request.phoneNumber,
                password = request.password,
                age = request.age,
                zone = request.zone,
                name = request.name,
                rewardPoint = 0,
            )
        )

        return jwtProvider.getToken(request.phoneNumber)
    }

    fun signIn(request: UserSignInRequest): TokenResponse {
        val user = userRepository.findByPhoneNumber(request.phoneNumber)
            ?: throw UserNotFoundException

        if (request.password != user.password) {
            throw UserPasswordMisMatchException
        }

        return jwtProvider.getToken(request.phoneNumber)
    }

    fun getMyInfo(): MyInfoElement {
        val user = userFacade.getCurrentUser()

        return MyInfoElement(
            name = user.name,
            age = user.age,
            zone = user.zone,
            phoneNumber = user.phoneNumber,
            rewardPoint = user.rewardPoint,
        )
    }
}
