package com.dsmdeliverybackend.domain.parcel.exception

import com.dsmdeliverybackend.global.error.DsmDeliveryException
import com.dsmdeliverybackend.global.error.ErrorCode

object ParcelNotFoundException : DsmDeliveryException (
    ErrorCode.PARCEL_NOT_FOUND
)