package com.dsmdeliverybackend.domain.selection.domain

import com.dsmdeliverybackend.domain.post.domain.Post
import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Table(name = "tbl_selection")
@Entity
class SelectionEntity (

    @EmbeddedId
    val Id: SelectionEntityId,

    @MapsId("post")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", columnDefinition = "BINARY(16)")
    @field:NotNull
    val post: Post,

    @MapsId("product")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", columnDefinition = "BINARY(16)")
    @field:NotNull
    val productEntity: ProductEntity,

    @Column(columnDefinition = "VARCHAR(2)")
    @field:NotNull
    val quantity: String

)