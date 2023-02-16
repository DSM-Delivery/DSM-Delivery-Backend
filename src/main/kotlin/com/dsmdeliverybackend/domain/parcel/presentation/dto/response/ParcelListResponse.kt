package com.dsmdeliverybackend.domain.parcel.presentation.dto.response

import java.util.UUID

data class ParcelListResponse(
    val parcelList: List<ParcelResponse>
)

class ParcelResponse(
    val percelId: UUID,

    val userName: String,

    val userPhoneNumber: String,


)