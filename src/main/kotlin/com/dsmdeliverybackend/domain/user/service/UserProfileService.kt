package com.dsmdeliverybackend.domain.user.service

import com.dsmdeliverybackend.domain.user.facade.UserFacade
import com.dsmdeliverybackend.domain.user.presentation.dto.response.UserProfileResponse
import org.springframework.stereotype.Service

@Service
class UserProfileService (
        private val userFacade: UserFacade
) {

    fun execute(): UserProfileResponse {
        val user = userFacade.getCurrentUser()

        return UserProfileResponse(
                name = user.userName,
                profileImg = user.profileImg
        )
    }
}