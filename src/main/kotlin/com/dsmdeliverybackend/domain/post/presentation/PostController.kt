package com.dsmdeliverybackend.domain.post.presentation

import com.dsmdeliverybackend.domain.post.presentation.dto.request.CreatePostRequest
import com.dsmdeliverybackend.domain.post.presentation.dto.response.PostListResponse
import com.dsmdeliverybackend.domain.post.presentation.dto.response.PostUUIDResponse
import com.dsmdeliverybackend.domain.post.service.CreatePostService
import com.dsmdeliverybackend.domain.post.service.QueryPostListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/post")
@RestController
class PostController (
    private val createPostService: CreatePostService,
    private val queryPostListService: QueryPostListService
) {

    @PostMapping
    fun createPost(@RequestBody request: CreatePostRequest): PostUUIDResponse {
        return createPostService.execute(request)
    }

    @GetMapping
    fun queryPostList(): PostListResponse {
        return queryPostListService.execute()
    }
}