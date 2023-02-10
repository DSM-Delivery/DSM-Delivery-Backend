package com.dsmdeliverybackend.domain.parcel.presentation.dto.response

import com.dsmdeliverybackend.domain.user.domain.User
import java.util.UUID

data class UserListResponse (
    val userList: List<UserResponse>
)

class UserResponse (
    val userId: UUID,
    val userName: String,
    val phoneNumber: String
) {
    constructor(user: User): this (
        userId = user.id,
        userName = user.userName,
        phoneNumber = user.phoneNumber
    )
}