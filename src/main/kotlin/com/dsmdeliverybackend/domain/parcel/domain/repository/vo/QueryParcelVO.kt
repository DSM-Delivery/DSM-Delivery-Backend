package com.dsmdeliverybackend.domain.parcel.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection
import java.util.UUID

class QueryParcelVO @QueryProjection constructor (
    val parcelId: UUID,

    val userName: String,

    val userPhoneNumber: String,

    val receive: Boolean
)