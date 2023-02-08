package com.dsmdeliverybackend.domain.product

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ProductRepository: CrudRepository<ProductEntity, UUID>