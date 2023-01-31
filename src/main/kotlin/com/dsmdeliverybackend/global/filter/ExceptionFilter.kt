package com.dsmdeliverybackend.global.filter

import com.dsmdeliverybackend.global.error.CustomException
import com.dsmdeliverybackend.global.error.response.BaseErrorResponse
import com.dsmdeliverybackend.global.exception.InternalServerError
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter (
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is CustomException -> setErrorMessage(e, response)
                else -> setErrorMessage(InternalServerError, response)
            }
        }
    }

    private fun setErrorMessage(e: CustomException, response: HttpServletResponse) {
        val errorResponse = BaseErrorResponse.of(e.errorCode)

        response.characterEncoding = StandardCharsets.UTF_8.toString()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = errorResponse.status
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }

}