package com.dsmdeliverybackend.domain.user.service

import com.dsmdeliverybackend.domain.refresh_token.dto.TokenRefreshUtil
import com.dsmdeliverybackend.domain.refresh_token.dto.response.TokenResponse
import org.springframework.stereotype.Service

@Service
class TokenRefreshService (
    private val refreshUtil: TokenRefreshUtil
) {

    fun execute(refreshToken: String): TokenResponse {
        return refreshUtil.tokenRefresh(refreshToken)
    }

}