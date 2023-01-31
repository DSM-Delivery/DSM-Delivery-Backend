package com.dsmdeliverybackend.global.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object InternalServerError : DsmDeliveryException(ErrorCode.INTERNAL_SERVER_ERROR) {

    val Exception = InternalServerError

}