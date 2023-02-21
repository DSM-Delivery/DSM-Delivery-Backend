package com.dsmdeliverybackend.domain.product.domain

import com.dsmdeliverybackend.global.entity.BaseUUIDEntity
import java.util.*
import javax.persistence.*

@Table(name = "tbl_product")
@Entity
class ProductEntity(

     id: UUID ?= null,

    @Column(columnDefinition = "CHAR(6)", nullable = false)
    val productType: String,

) :BaseUUIDEntity(id)
