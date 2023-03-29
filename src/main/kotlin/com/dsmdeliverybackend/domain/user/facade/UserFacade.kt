package com.dsmdeliverybackend.domain.user.facade

import com.dsmdeliverybackend.domain.refresh_token.domain.RefreshToken
import com.dsmdeliverybackend.domain.refresh_token.domain.repository.RefreshTokenRepository
import com.dsmdeliverybackend.domain.refresh_token.dto.response.TokenResponse
import com.dsmdeliverybackend.domain.user.domain.User
import com.dsmdeliverybackend.domain.user.domain.repository.UserRepository
import com.dsmdeliverybackend.domain.user.exception.UserNotFoundException
import com.dsmdeliverybackend.global.security.jwt.SecurityProperties
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserFacade (
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val securityProperties: SecurityProperties
) {

    fun saveUser(user: User) {
        userRepository.save(user)
    }

    fun getCurrentUser(): User {
        val accountId = SecurityContextHolder.getContext().authentication.name
        return getUserByAccountId(accountId)
    }

    fun getUserByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }

    fun getUserByUUID(id: UUID): User {
        return userRepository.findByIdOrNull(id) ?: throw UserNotFoundException
    }

    fun isAlreadyExist(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

    fun saveToken(user: User, response: TokenResponse): TokenResponse {

        refreshTokenRepository.save(
            RefreshToken (
                accountId = user.id,
                token = response.refreshToken,
                expiredAt = System.currentTimeMillis() + securityProperties.accessExp * 1000
            )
        )
        return response
    }

}