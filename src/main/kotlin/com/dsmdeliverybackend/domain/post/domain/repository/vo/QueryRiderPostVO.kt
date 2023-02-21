package com.dsmdeliverybackend.domain.post.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection
import java.util.UUID

class QueryRiderPostVO @QueryProjection constructor(
    val title: String,

    val userName: String,

    val cost: String,

    val postId: UUID,

    val profileImg: String,

    val star: Int
)