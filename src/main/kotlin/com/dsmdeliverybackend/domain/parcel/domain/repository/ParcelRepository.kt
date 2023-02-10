package com.dsmdeliverybackend.domain.parcel.domain.repository

import com.dsmdeliverybackend.domain.parcel.domain.Parcel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ParcelRepository : CrudRepository<Parcel, UUID>, CustomParcelRepository {
}