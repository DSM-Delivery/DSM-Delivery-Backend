package com.dsmdeliverybackend.domain.conclusion.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object ConclusionNotFoundException : DsmDeliveryException (
    ErrorCode.CONCLUSION_NOT_FOUND
)