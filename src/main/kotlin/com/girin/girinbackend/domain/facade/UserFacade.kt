package com.girin.girinbackend.domain.facade

import com.girin.girinbackend.common.exception.UserNotFoundException
import com.girin.girinbackend.domain.entity.user.User
import com.girin.girinbackend.domain.repository.UserRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository,
) {

    fun getCurrentUser(): User {
        val userIdentifier = SecurityContextHolder.getContext().authentication.name

        return userRepository.findByPhoneNumber(userIdentifier)
            ?: throw UserNotFoundException
    }
}
