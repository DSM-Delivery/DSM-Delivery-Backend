package com.dsmdeliverybackend.domain.post.presentation.dto.response

import com.dsmdeliverybackend.global.enum.PostType
import java.util.*

data class PostListResponse (
    val postList: List<PostResponse>
)

class PostResponse (
    val title: String,

    val userName: String,

    val cost: String,

    val postId: UUID,

    val profileImg: String,

    val star: Int,

    val postType: String
)