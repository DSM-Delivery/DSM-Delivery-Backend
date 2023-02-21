package com.dsmdeliverybackend.domain.snack.service

import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.domain.snack.exception.SnackAlreadyExistException
import com.dsmdeliverybackend.domain.snack.facade.SnackFacade
import com.dsmdeliverybackend.domain.snack.presentation.dto.request.AddSnackRequest
import com.dsmdeliverybackend.domain.product.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class AddSnackService (
    private val snackFacade: SnackFacade,
    private val productRepository: ProductRepository
) {

    fun execute(request: AddSnackRequest) {

        if (snackFacade.isAlreadyExist(request.snackName)) {
            throw SnackAlreadyExistException
        }

        val product = ProductEntity(id = null, productType = "SNACK")

        productRepository.save(product)

        snackFacade.saveSnack(request, product)

    }

}