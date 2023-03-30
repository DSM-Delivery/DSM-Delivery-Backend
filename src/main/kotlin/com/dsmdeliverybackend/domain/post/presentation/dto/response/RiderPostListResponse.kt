package com.dsmdeliverybackend.domain.post.presentation.dto.response

import java.util.UUID

data class RiderPostListResponse (
    val postList: List<RiderResponse>
)

class RiderResponse (
    val title: String,

    val userName: String,

    val cost: String,

    val postId: UUID,

    val profileImg: String,

    val star: Float
)