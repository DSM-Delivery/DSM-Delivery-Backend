package com.dsmdeliverybackend.domain.product.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object ProductNotFoundException : DsmDeliveryException (
    ErrorCode.PRODUCT_NOT_FOUND
)