package com.dsmdeliverybackend.global.error

import com.dsmdeliverybackend.global.error.response.ErrorResponse

open class DsmDeliveryException (val errorCode: ErrorResponse) : RuntimeException() { //TODO 매개변수에 errorcode가 들어가야할지 errorResponse가 들어갈지
    val status: Int
        get() = errorCode.status

    override val message
        get() = errorCode.message
}