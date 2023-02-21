package com.dsmdeliverybackend.domain.parcel.service

import com.dsmdeliverybackend.domain.parcel.facade.ParcelFacade
import com.dsmdeliverybackend.domain.parcel.presentation.dto.request.CreateParcelRequest
import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.domain.product.domain.repository.ProductRepository
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import com.dsmdeliverybackend.global.enum.ProductType
import org.springframework.stereotype.Service

@Service
class CreateParcelService (
    private val userFacade: UserFacade,
    private val parcelFacade: ParcelFacade,
    private val productRepository: ProductRepository
) {

    fun execute(request: CreateParcelRequest) {

        val product = ProductEntity(id = null, productType = "PARCEL")

        productRepository.save(product)

        val user = userFacade.getUserByUUID(request.userId)

        parcelFacade.saveParcel(user, product)

    }
}