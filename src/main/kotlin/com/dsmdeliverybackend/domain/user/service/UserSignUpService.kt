package com.dsmdeliverybackend.domain.user.service

import com.dsmdeliverybackend.domain.user.exception.UserAlreadyExistException
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import com.dsmdeliverybackend.domain.user.presentation.dto.request.UserSignUpRequest
import com.dsmdeliverybackend.global.util.mapper.UserMapper
import org.springframework.stereotype.Service

@Service
class UserSignUpService(
    private val userFacade: UserFacade,
    private val userMapper: UserMapper
) {

    fun execute(request: UserSignUpRequest) {

        if (userFacade.isAlreadyExist(request.accountId)) {
            throw UserAlreadyExistException
        }

        userFacade.saveUser(
            userMapper.payloadToEntity(request)
        )

    }
}