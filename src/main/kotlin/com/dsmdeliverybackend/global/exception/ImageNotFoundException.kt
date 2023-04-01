package com.dsmdeliverybackend.global.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object ImageNotFoundException : DsmDeliveryException (
    ErrorCode.IMAGE_NOT_FOUND
)