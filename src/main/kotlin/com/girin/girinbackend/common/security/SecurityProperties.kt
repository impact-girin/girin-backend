package com.girin.girinbackend.common.security

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class SecurityProperties(
    val accessExp: Long,
    val secretKey: String,
)
