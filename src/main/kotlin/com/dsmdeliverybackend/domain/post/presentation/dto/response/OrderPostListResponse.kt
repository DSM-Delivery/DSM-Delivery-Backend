package com.dsmdeliverybackend.domain.post.presentation.dto.response

import java.util.*

data class OrderPostListResponse (
    val postList: List<PostResponse>
)

class PostResponse (
    val title: String,

    val userName: String,

    val cost: String,

    val postId: UUID,

    val profileImg: String,

    val productType: String
)