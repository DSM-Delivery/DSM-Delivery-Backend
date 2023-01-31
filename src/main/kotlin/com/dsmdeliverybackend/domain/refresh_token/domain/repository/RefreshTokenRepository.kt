package com.dsmdeliverybackend.domain.refresh_token.domain.repository

import com.dsmdeliverybackend.domain.refresh_token.domain.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshToken, UUID> {
    fun findByToken(refreshToken: String): Optional<RefreshToken>
}

