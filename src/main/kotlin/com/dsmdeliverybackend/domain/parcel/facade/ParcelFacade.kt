package com.dsmdeliverybackend.domain.parcel.facade

import com.dsmdeliverybackend.domain.parcel.domain.Parcel
import com.dsmdeliverybackend.domain.parcel.domain.repository.ParcelRepository
import com.dsmdeliverybackend.domain.product.ProductEntity
import com.dsmdeliverybackend.domain.user.domain.User
import org.springframework.stereotype.Component

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
                user = user
            )
        )
    }

}