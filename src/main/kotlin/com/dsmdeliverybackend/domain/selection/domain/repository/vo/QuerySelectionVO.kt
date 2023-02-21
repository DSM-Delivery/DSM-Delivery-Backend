package com.dsmdeliverybackend.domain.selection.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection

class QuerySelectionVO @QueryProjection constructor(
    val productName: String,

    val quantity: String
)