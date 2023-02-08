package com.dsmdeliverybackend.domain.product

import com.dsmdeliverybackend.global.entity.BaseUUIDEntity
import com.dsmdeliverybackend.global.enum.ProductType
import java.util.*
import javax.persistence.*

@Table(name = "tbl_product")
@Entity
class ProductEntity(

     id: UUID ?= null,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(6)", nullable = false)
    val productType: ProductType,

) :BaseUUIDEntity(id)
