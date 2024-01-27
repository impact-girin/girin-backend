package com.girin.girinbackend.domain.facade

import com.girin.girinbackend.common.exception.UserNotFoundException
import com.girin.girinbackend.domain.entity.user.User
import com.girin.girinbackend.domain.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository,
) {

    fun getCurrentUser(): User {
        val userId = SecurityContextHolder.getContext().authentication.name

        return userRepository.findByIdOrNull(userId.toLong())
            ?: throw UserNotFoundException
    }
}
