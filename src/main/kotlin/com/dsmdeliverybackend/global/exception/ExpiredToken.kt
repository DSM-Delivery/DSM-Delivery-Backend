package com.dsmdeliverybackend.global.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object ExpiredToken : DsmDeliveryException(ErrorCode.EXPIRED_TOKEN) {

    val Exception = ExpiredToken
}