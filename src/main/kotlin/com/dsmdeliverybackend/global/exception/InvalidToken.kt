package com.dsmdeliverybackend.global.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object InvalidToken : DsmDeliveryException(ErrorCode.INVALID_TOKEN) {

    val Exception = InvalidToken

}