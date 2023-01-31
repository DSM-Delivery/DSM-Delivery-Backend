package com.dsmdeliverybackend.domain.user.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object UserAlreadyExistException : DsmDeliveryException(
    ErrorCode.USER_ALREADY_EXIST
)