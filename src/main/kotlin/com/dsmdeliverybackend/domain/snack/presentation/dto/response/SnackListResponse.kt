package com.dsmdeliverybackend.domain.snack.presentation.dto.response

import com.dsmdeliverybackend.domain.snack.domain.Snack
import com.dsmdeliverybackend.global.enum.SnackType

data class SnackListResponse(
    val snackList: List<SnackResponse>
)

class SnackResponse(
    val snackName: String,
    val price: String,
    val snackType: SnackType
) {
    constructor(snack: Snack) : this(
        snackName = snack.snackName,
        price = snack.price,
        snackType = snack.snackType
    )
}


