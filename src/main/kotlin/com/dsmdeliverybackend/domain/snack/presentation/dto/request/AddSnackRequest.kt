package com.dsmdeliverybackend.domain.snack.presentation.dto.request

import com.dsmdeliverybackend.global.enum.SnackType
import javax.validation.constraints.NotNull

class AddSnackRequest (

    @field:NotNull
    val snackName: String,

    @field:NotNull
    val price : String,

    @field:NotNull
    val snackType: SnackType

)