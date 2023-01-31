package com.dsmdeliverybackend.global.security.jwt

import com.dsmdeliverybackend.domain.refresh_token.dto.response.TokenResponse
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*

import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class JwtProvider (
    private val securityProperties: SecurityProperties
) {

    private fun createAccessToken(userId: UUID) =
        generateToken(userId, JwtProperties.ACCESS, securityProperties.accessExp)

    private fun createRefreshToken(userId: UUID) =
        generateToken(userId, JwtProperties.REFRESH, securityProperties.refreshExp)

    private fun generateToken(userId: UUID, type:String, expiredAt: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(userId.toString())
            .setHeaderParam("type", "jwt")
            .claim("type", type)
            .setExpiration(Date(System.currentTimeMillis() + securityProperties.accessExp * 1000))
            .compact()

    fun provideBothToken(userId: UUID) = TokenResponse(
        accessToken = createAccessToken(userId),
        refreshToken = createRefreshToken(userId),
        accessTokenExp = LocalDateTime.now().plusSeconds(securityProperties.accessExp)
    )

}