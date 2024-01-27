package com.girin.girinbackend.common.security.auth

import com.girin.girinbackend.common.exception.UserNotFoundException
import com.girin.girinbackend.domain.repository.user.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(
    private val userRepository: UserRepository,
) : UserDetailsService {

    override fun loadUserByUsername(userId: String?): UserDetails {
        val user = userRepository.findByIdOrNull(userId?.toLong()!!)
            ?: throw UserNotFoundException

        return UserDetails(user.id)
    }
}
