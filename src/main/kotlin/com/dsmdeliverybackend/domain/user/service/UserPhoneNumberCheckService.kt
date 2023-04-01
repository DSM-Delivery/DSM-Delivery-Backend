package com.dsmdeliverybackend.domain.user.service

import com.dsmdeliverybackend.domain.user.presentation.dto.response.SmsCheckResponse
import com.dsmdeliverybackend.global.util.mapper.PhoneNumberCheckMapper
import org.springframework.stereotype.Service


@Service
class UserPhoneNumberCheckService (
    private val phoneNumberCheckMapper: PhoneNumberCheckMapper
) {

    fun execute(to: String): SmsCheckResponse {
        return phoneNumberCheckMapper.sendMessage(to)
    }

}