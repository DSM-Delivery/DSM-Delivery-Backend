package com.dsmdeliverybackend.domain.post.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection

class QueryPostDetailVO @QueryProjection constructor(
    val title: String,

    val content: String,

    val cost: String,

    val userName: String,

    val profileImg: String,

    val star: Int
)