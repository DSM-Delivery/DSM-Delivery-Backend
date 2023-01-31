package com.dsmdeliverybackend.global.error.response

import com.dsmdeliverybackend.global.error.ErrorCode

class BaseErrorResponse(
    val status: Int,
    val message: String,
) {
    companion object {
        fun of(e: ErrorCode): BaseErrorResponse {
            return BaseErrorResponse(
                message = e.message,
                status = e.status,
            )
        }
    }
}