package com.dsmdeliverybackend.domain.selection.presentation.dto.request

import com.dsmdeliverybackend.global.enum.ProductType
import java.util.UUID

data class CreateSelectionRequest (
    val postId: UUID,

    val selectionList: List<SelectionList>

)

class SelectionList(
    val productId: UUID,
    val quantity: String,
    val productType: ProductType
)