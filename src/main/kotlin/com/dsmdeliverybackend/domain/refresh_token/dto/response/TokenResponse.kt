package com.dsmdeliverybackend.domain.refresh_token.dto.response

import io.jsonwebtoken.JwtBuilder
import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExp: LocalDateTime
)