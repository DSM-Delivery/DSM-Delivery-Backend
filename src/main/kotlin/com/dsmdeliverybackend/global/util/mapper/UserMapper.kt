package com.dsmdeliverybackend.global.util.mapper

import com.dsmdeliverybackend.domain.user.domain.User
import com.dsmdeliverybackend.domain.user.presentation.dto.request.UserSignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class UserMapper (
    private val passwordEncoder: PasswordEncoder,
){
    fun payloadToEntity(request: UserSignUpRequest): User {
        return User(
            accountId = request.accountId,
            password = passwordEncoder.encode(request.password),
            userName = request.name,
            phoneNumber = request.phoneNumber,
            sex = request.sex,
            role = request.role,
            canDriver = false,
            profileImg = request.imagePath ?: "https://",
            star = 0,
            starCount = 0
        )
    }

}