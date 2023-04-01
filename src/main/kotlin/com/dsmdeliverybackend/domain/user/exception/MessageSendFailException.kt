package com.dsmdeliverybackend.domain.user.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object MessageSendFailException : DsmDeliveryException (
    ErrorCode.MESSAGE_SEND_FAILED
)