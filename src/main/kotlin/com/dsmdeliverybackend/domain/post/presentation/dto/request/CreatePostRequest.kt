package com.dsmdeliverybackend.domain.post.presentation.dto.request

import com.dsmdeliverybackend.global.enum.PostType
import javax.validation.constraints.NotBlank

class CreatePostRequest (

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val content: String,

    @field:NotBlank
    val cost: String,

    @field:NotBlank
    val postType: PostType,

    val selectionList: List<SelectionListRequest>

)
