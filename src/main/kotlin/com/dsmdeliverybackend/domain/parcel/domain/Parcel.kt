package com.dsmdeliverybackend.domain.parcel.domain

import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.domain.user.domain.User
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "tbl_parcel")
class Parcel (

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @field:NotNull
    val productId: UUID,

    @MapsId("product_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinColumn(name = "product_id", columnDefinition = "BINARY(16)")
    @field:NotNull
    val productEntity: ProductEntity,

    receive: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User

) {

    @field:NotNull
    @Column(columnDefinition = "BIT(1)")
    var receive = receive
        protected set

    fun Inspection (receive: Boolean) {
        this.receive = receive
    }

}