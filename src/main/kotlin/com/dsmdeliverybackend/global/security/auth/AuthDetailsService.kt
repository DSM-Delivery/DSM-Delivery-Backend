package com.dsmdeliverybackend.global.security.auth

import com.dsmdeliverybackend.domain.user.domain.repository.UserRepository
import com.dsmdeliverybackend.domain.user.exception.UserNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class AuthDetailsService (
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String?): UserDetails {
        val user = userRepository.findByIdOrNull(UUID.fromString(accountId))
            ?:throw UserNotFoundException
        return AuthDetails(user)
    }

}