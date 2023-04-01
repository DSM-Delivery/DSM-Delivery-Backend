package com.dsmdeliverybackend.infrastructure.sms

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "cool-sms")
class SmsProperties (

    val key: String,

    val secret: String,

    val phoneNumber: String

)