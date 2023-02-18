package com.dsmdeliverybackend.domain.post.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object PostNotFoundException : DsmDeliveryException (
    ErrorCode.POST_NOT_FOUND
)