package com.dsmdeliverybackend.domain.user.service

import com.dsmdeliverybackend.domain.user.facade.UserFacade
import com.dsmdeliverybackend.domain.user.presentation.dto.request.UserStarRequest
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserStarAvgService (
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: UserStarRequest) {

        val user = userFacade.getUserByUUID(request.userId)

        val starAvg = (user.star * user.starCount + request.star) / (user.starCount + 1)

        user.modifyStar(starAvg)
    }
}