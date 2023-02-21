package com.dsmdeliverybackend.domain.parcel.facade

import com.dsmdeliverybackend.domain.parcel.domain.Parcel
import com.dsmdeliverybackend.domain.parcel.domain.repository.ParcelRepository
import com.dsmdeliverybackend.domain.parcel.exception.ParcelNotFoundException
import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.domain.user.domain.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ParcelFacade (
    private val parcelRepository: ParcelRepository
) {

    fun saveParcel(user: User, product: ProductEntity) {
        parcelRepository.save(
            Parcel(
                productId = product.id,
                productEntity = product,
                receive = false,
                user = user,
                parcelName = "택배"
            )
        )
    }

    fun getByParcelUUID(parcelId: UUID): Parcel {
        return parcelRepository.findByIdOrNull(parcelId)
            ?: throw ParcelNotFoundException
    }

}