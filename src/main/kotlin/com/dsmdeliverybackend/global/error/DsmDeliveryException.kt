package com.dsmdeliverybackend.global.error

abstract class DsmDeliveryException (
    val errorCode: ErrorCode
) : RuntimeException()