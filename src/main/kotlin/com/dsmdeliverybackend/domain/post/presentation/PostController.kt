package com.dsmdeliverybackend.domain.post.presentation

import com.dsmdeliverybackend.domain.post.presentation.dto.request.CreatePostRequest
import com.dsmdeliverybackend.domain.post.service.CreatePostService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/post")
@RestController
class PostController (
    private val createPostService: CreatePostService,
) {

    @PostMapping
    fun postMapping(@RequestBody request: CreatePostRequest) {
        createPostService.execute(request)
    }

}