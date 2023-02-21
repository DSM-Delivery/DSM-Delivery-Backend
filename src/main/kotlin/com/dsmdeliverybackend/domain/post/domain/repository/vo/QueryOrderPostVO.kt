package com.dsmdeliverybackend.domain.post.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection
import java.util.*

class QueryOrderPostVO @QueryProjection constructor(
    val title: String,

    val userName: String,

    val cost: String,

    val postId: UUID,

    val profileImg: String,

    val star: Int,

    val productType: String

)