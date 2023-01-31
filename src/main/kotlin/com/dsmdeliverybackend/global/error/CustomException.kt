package com.dsmdeliverybackend.global.error

abstract class CustomException (
    val errorCode: ErrorCode
) : RuntimeException()