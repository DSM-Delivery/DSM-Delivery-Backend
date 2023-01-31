package com.dsmdeliverybackend.domain.user.service

import com.dsmdeliverybackend.domain.user.exception.PasswordMisMatchException
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import com.dsmdeliverybackend.domain.user.presentation.dto.request.UserSignInRequest
import com.dsmdeliverybackend.domain.refresh_token.dto.response.TokenResponse
import com.dsmdeliverybackend.global.security.jwt.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserSignInService (
    private val userFacade: UserFacade,
    private val jwtProvider: JwtProvider,
    private val passwordEncoder: PasswordEncoder,
) {

    fun execute(request: UserSignInRequest): TokenResponse {

        val user = userFacade.getUserByAccountId(request.accountId)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMisMatchException
        }

        val response = jwtProvider.provideBothToken(user.id)

        return userFacade.saveToken(user, response)

    }

}