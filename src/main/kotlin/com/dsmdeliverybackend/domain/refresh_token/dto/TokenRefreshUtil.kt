package com.dsmdeliverybackend.domain.refresh_token.dto

import com.dsmdeliverybackend.domain.refresh_token.domain.repository.RefreshTokenRepository
import com.dsmdeliverybackend.domain.refresh_token.dto.response.TokenResponse
import com.dsmdeliverybackend.global.exception.InvalidToken
import com.dsmdeliverybackend.global.security.jwt.JwtParser
import com.dsmdeliverybackend.global.security.jwt.JwtProvider
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class TokenRefreshUtil (
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProvider: JwtProvider,
    private val jwtParser: JwtParser,
    @Value("\${jwt.refresh_exp}")
    private val ttl: Long
) {

    fun tokenRefresh(refreshToken: String): TokenResponse {
        if (jwtParser.isNotRefreshToken(refreshToken)) {
            throw InvalidToken.Exception
        }

        return refreshTokenRepository.findByToken(refreshToken)
            .get()
            .let { token ->
                val id = token.accountId
                val tokenResponse = jwtProvider.provideBothToken(id)
                token.updateToken(token.token, ttl)
                return tokenResponse
            }
    }
}