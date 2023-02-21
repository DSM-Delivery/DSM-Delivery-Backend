package com.dsmdeliverybackend.domain.selection.presentation.dto.response

data class QuerySelectionResponse (
    val selectionList: List<SelectionResponse>
)

class SelectionResponse(
    val productName: String,

    val quantity: String
)