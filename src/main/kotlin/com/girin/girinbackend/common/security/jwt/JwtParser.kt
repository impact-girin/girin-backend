package com.girin.girinbackend.common.security.jwt

import com.girin.girinbackend.common.exception.ExpiredTokenException
import com.girin.girinbackend.common.exception.InternalServerErrorException
import com.girin.girinbackend.common.exception.InvalidTokenException
import com.girin.girinbackend.common.security.SecurityProperties
import com.girin.girinbackend.common.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService,
) {

    private fun getClaims(token: String): Claims =
        try {
            Jwts.parser()
                .setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidTokenException
                is ExpiredJwtException -> throw ExpiredTokenException
                else -> throw InternalServerErrorException
            }
        }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)
        val authDetails = authDetailsService.loadUserByUsername(claims.subject)
        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }
}
