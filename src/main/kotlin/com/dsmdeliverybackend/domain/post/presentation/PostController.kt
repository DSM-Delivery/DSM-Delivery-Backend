package com.dsmdeliverybackend.domain.post.presentation

import com.dsmdeliverybackend.domain.post.presentation.dto.request.CreatePostRequest
import com.dsmdeliverybackend.domain.post.presentation.dto.response.OrderPostListResponse
import com.dsmdeliverybackend.domain.post.presentation.dto.response.PostUUIDResponse
import com.dsmdeliverybackend.domain.post.presentation.dto.response.QueryPostDetailResponse
import com.dsmdeliverybackend.domain.post.presentation.dto.response.RiderPostListResponse
import com.dsmdeliverybackend.domain.post.service.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/post")
@RestController
class PostController (
    private val createPostService: CreatePostService,
    private val queryOrderPostListService: QueryOrderPostListService,
    private val queryPostDetailService: QueryPostDetailService,
    private val queryRiderPostListService: QueryRiderPostListService,
    private val deliveryCompleteService: DeliveryCompleteService
) {

    @PostMapping
    fun createPost(@RequestBody request: CreatePostRequest): PostUUIDResponse {
        return createPostService.execute(request)
    }

    @PostMapping("/{post-id}")
    fun deliveryComplete(@PathVariable("post-id") request: UUID) {
        deliveryCompleteService.execute(request)
    }

    @GetMapping("/order")
    fun queryOrderPostList(): OrderPostListResponse {
        return queryOrderPostListService.execute()
    }

    @GetMapping("/rider")
    fun queryRiderPostList(): RiderPostListResponse {
        return queryRiderPostListService.execute()
    }

    @GetMapping("/{post-id}")
    fun queryPostDetail(@PathVariable("post-id") postId: UUID): QueryPostDetailResponse {
        return queryPostDetailService.execute(postId)
    }
}