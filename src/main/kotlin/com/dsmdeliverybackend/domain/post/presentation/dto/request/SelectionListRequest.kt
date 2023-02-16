package com.dsmdeliverybackend.domain.post.presentation.dto.request

import com.dsmdeliverybackend.global.enum.ProductType
import java.util.UUID

class SelectionListRequest (
    val productId: UUID,
    val quantity: String,
    val productType: ProductType
)