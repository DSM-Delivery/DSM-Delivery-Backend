package com.dsmdeliverybackend.global.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object SaveImageFailedException : DsmDeliveryException (
    ErrorCode.SAVE_IMAGE_FAILED
)