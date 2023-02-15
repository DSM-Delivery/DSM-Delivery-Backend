package com.dsmdeliverybackend.domain.product.domain.repository

import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ProductRepository: CrudRepository<ProductEntity, UUID>