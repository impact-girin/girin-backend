package com.girin.girinbackend.common.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.girin.girinbackend.common.security.jwt.JwtParser
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtParser: JwtParser,
    private val objectMapper: ObjectMapper,
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(securityBuilder: HttpSecurity) {
        securityBuilder.addFilterBefore(
            JwtFilter(jwtParser),
            UsernamePasswordAuthenticationFilter::class.java
        )
        securityBuilder.addFilterBefore(
            ExceptionFilter(objectMapper),
            JwtFilter::class.java,
        )
    }
}
