package com.dsmdeliverybackend.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UserSignInRequest (

    @field:NotBlank
    val accountId: String,

    @field:NotNull
    val password: String
)