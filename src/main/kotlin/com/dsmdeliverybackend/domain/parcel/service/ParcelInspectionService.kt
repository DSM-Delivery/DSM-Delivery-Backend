package com.dsmdeliverybackend.domain.parcel.service

import com.dsmdeliverybackend.domain.parcel.facade.ParcelFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class ParcelInspectionService (
    private val parcelFacade: ParcelFacade
) {

    @Transactional
    fun execute(parcelId: UUID) {
        val parcel = parcelFacade.getByParcelUUID(parcelId)

        parcel.Inspection(true)
    }

}