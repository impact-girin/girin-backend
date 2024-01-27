package com.girin.girinbackend.common.security.auth

import com.girin.girinbackend.common.exception.UserNotFoundException
import com.girin.girinbackend.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository,
) : UserDetailsService {

    override fun loadUserByUsername(phoneNumber: String?): AuthDetails {
        val user = userRepository.findByPhoneNumber(phoneNumber!!)
            ?: throw UserNotFoundException

        return AuthDetails(user.phoneNumber)
    }
}
