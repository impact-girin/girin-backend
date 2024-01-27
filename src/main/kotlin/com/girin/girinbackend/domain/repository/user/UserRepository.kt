package com.girin.girinbackend.domain.repository.user

import com.girin.girinbackend.domain.entity.user.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>
