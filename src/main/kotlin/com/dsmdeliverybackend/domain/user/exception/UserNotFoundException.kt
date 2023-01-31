package com.dsmdeliverybackend.domain.user.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object UserNotFoundException : DsmDeliveryException(
    ErrorCode.USER_NOT_FOUND
)