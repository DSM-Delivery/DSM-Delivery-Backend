package com.dsmdeliverybackend.domain.refresh_token.domain

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import java.util.UUID
import org.springframework.data.annotation.Id

@RedisHash
class RefreshToken (

    @Id
    val accountId: UUID,

    @Indexed
    var token: String,

    @TimeToLive
    var expiredAt: Long

) {
    fun updateToken(token: String, expiredAt: Long) {
        this.token = token
        this.expiredAt = expiredAt
    }

}