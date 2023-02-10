package com.dsmdeliverybackend.domain.parcel.presentation.dto.request

import java.util.UUID
import javax.validation.constraints.NotNull

class CreateParcelRequest (

    @field:NotNull
    val userId: UUID
)