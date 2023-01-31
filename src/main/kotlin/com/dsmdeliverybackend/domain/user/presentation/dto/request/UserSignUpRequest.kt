package com.dsmdeliverybackend.domain.user.presentation.dto.request

import com.dsmdeliverybackend.global.enum.Role
import com.dsmdeliverybackend.global.enum.Sex
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class UserSignUpRequest (

    @field:NotNull
    @field:Size(min = 5, max = 20)
    val accountId: String,

    @field:NotBlank
    @field:Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}$")
    val password: String,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val imagePath: String,

    @field:NotBlank
    val phoneNumber: String,

    @field:NotBlank
    val sex: Sex,

    @field:NotBlank
    val role: Role

 )
