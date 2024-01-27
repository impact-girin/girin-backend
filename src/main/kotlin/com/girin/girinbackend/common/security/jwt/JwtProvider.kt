package com.girin.girinbackend.common.security.jwt

import com.girin.girinbackend.common.security.SecurityProperties
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.Date

data class TokenResponse(
    val accessToken: String,
    val accessTokenExpiredAt: LocalDateTime,
)

@Component
class JwtProvider(
    private val securityProperties: SecurityProperties,
) {

    private fun createToken(phoneNumber: String) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(phoneNumber)
            .setHeaderParam(Header.JWT_TYPE, "access")
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .compact()

    fun getToken(phoneNumber: String) = TokenResponse(
        accessToken = createToken(phoneNumber),
        accessTokenExpiredAt = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
    )
}
