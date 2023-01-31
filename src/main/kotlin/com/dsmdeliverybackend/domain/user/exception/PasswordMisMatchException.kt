package com.dsmdeliverybackend.domain.user.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object PasswordMisMatchException : DsmDeliveryException (
    ErrorCode.PASSWORD_MIS_MATCH
)