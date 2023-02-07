package com.dsmdeliverybackend.domain.snack.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object SnackNotFoundException : DsmDeliveryException (
    ErrorCode.SNACK_NOT_FOUND
)