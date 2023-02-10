package com.dsmdeliverybackend.domain.parcel.service

import com.dsmdeliverybackend.domain.parcel.presentation.dto.response.UserListResponse
import com.dsmdeliverybackend.domain.parcel.presentation.dto.response.UserResponse
import com.dsmdeliverybackend.domain.user.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class QueryUserListService (
    private val userRepository: UserRepository
) {

    fun execute(): UserListResponse {
        val userList = userRepository.findAll()
            .map { UserResponse(it) }
            .toList()

        return UserListResponse(userList)
    }

}