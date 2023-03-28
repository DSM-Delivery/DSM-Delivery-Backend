package com.dsmdeliverybackend.domain.post.presentation.dto.request

import javax.validation.constraints.NotBlank

class CreatePostRequest (

    @field:NotBlank
    val title: String,

    @field:NotBlank
    val content: String,

    @field:NotBlank
    val cost: String,

    @field:NotBlank
    val location: String,

    @field:NotBlank
    val riderRequest: String,

    @field:NotBlank
    val postType: String,

)