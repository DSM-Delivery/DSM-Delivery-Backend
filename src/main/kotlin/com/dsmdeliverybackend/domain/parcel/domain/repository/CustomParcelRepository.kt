package com.dsmdeliverybackend.domain.parcel.domain.repository

import com.dsmdeliverybackend.domain.parcel.domain.repository.vo.QueryParcelVO

interface CustomParcelRepository {
    fun queryParcelList(): List<QueryParcelVO>
}