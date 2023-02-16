package com.dsmdeliverybackend.global.error

import com.dsmdeliverybackend.global.error.response.ErrorResponse

open class DsmDeliveryException (val errorCode: ErrorResponse) : RuntimeException() {
    val status: Int
        get() = errorCode.status

    override val message
        get() = errorCode.message
}