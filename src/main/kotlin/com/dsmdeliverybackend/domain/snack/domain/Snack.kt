package com.dsmdeliverybackend.domain.snack.domain

import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.global.enum.SnackType
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity(name = "tbl_snack")
class Snack(

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @field:NotNull
    val productId: UUID,

    @MapsId("product_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinColumn(name = "product_id", columnDefinition = "BINARY(16)")
    @field:NotNull
    val productEntity: ProductEntity,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(15)")
    val snackName: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(5)")
    val price: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(8)")
    val snackType : SnackType

)