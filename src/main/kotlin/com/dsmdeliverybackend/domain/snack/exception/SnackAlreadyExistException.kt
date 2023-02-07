package com.dsmdeliverybackend.domain.snack.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object SnackAlreadyExistException : DsmDeliveryException(
    ErrorCode.SNACK_ALREADY_EXIST
)