package com.dsmdeliverybackend.domain.product.facade

import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.domain.product.domain.repository.ProductRepository
import com.dsmdeliverybackend.domain.product.exception.ProductNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ProductFacade (
    private val productRepository: ProductRepository
) {

    fun getProductByUUID(id: UUID): ProductEntity {
        return productRepository.findByIdOrNull(id) ?: throw ProductNotFoundException
    }
}