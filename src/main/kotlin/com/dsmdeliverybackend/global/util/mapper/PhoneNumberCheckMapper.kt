package com.dsmdeliverybackend.global.util.mapper

import com.dsmdeliverybackend.domain.user.exception.MessageSendFailException
import com.dsmdeliverybackend.domain.user.presentation.dto.response.SmsCheckResponse
import com.dsmdeliverybackend.infrastructure.sms.SmsProperties
import net.nurigo.sdk.NurigoApp
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException
import net.nurigo.sdk.message.model.Message
import org.springframework.stereotype.Component
import java.util.*

@Component
class PhoneNumberCheckMapper(
    private val smsProperties: SmsProperties
) {
    val messageService = NurigoApp.initialize(smsProperties.key, smsProperties.secret, "https://api.coolsms.co.kr")

    fun sendMessage(to: String): SmsCheckResponse {

        val rand = Random()
        var numStr = ""

        for (i in 0..3) {
            val ran = rand.nextInt(10).toString()
            numStr += ran
        }

        val message = Message()
        message.from  = smsProperties.phoneNumber
        message.to = to
        message.text = "Dsm_Delivery 인증번호는 [$numStr] 입니다."

        try {
            messageService.send(message)
        } catch (exception: NurigoMessageNotReceivedException) {

            throw MessageSendFailException
            println(exception.failedMessageList)
            println(exception.message)

        } catch (exception: Exception) {
            println(exception.message)
        }

        return SmsCheckResponse(numStr)
    }
}