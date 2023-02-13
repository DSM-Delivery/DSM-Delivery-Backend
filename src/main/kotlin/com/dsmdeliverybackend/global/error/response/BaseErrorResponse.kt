package com.dsmdeliverybackend.global.error.response

import com.dsmdeliverybackend.global.error.DsmDeliveryException

class BaseErrorResponse (
    val status: Int,
    val message: String
) {

    companion object {
        fun of(e: DsmDeliveryException): BaseErrorResponse {
            return BaseErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }
}