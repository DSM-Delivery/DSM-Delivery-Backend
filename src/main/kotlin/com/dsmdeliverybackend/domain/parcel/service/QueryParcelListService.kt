package com.dsmdeliverybackend.domain.parcel.service

import com.dsmdeliverybackend.domain.parcel.domain.repository.ParcelRepository
import com.dsmdeliverybackend.domain.parcel.presentation.dto.response.ParcelListResponse
import com.dsmdeliverybackend.domain.parcel.presentation.dto.response.ParcelResponse
import org.springframework.stereotype.Service

@Service
class QueryParcelListService (
    private val parcelRepository: ParcelRepository
) {

    fun execute(): ParcelListResponse {
        val parcelList = parcelRepository.queryParcelList()

        return ParcelListResponse(
            parcelList = parcelList
                .map {
                    ParcelResponse(
                        percelId = it.parcelId,
                        userName = it.userName,
                        userPhoneNumber = it.userPhoneNumber
                    )
                }
        )
    }

}