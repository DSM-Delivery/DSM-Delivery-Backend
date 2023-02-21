package com.dsmdeliverybackend.domain.post.service

import com.dsmdeliverybackend.domain.post.domain.repository.PostRepository
import com.dsmdeliverybackend.domain.post.presentation.dto.response.OrderPostListResponse
import com.dsmdeliverybackend.domain.post.presentation.dto.response.PostResponse
import org.springframework.stereotype.Service

@Service
class QueryOrderPostListService (
    private val postRepository: PostRepository
) {

    fun execute(): OrderPostListResponse {
        val postList = postRepository.queryOrderPostList()

        return OrderPostListResponse(
            postList =  postList
                .map {
                    PostResponse(
                        title = it.title,
                        userName = it.userName,
                        cost = it.cost,
                        postId = it.postId,
                        profileImg = it.profileImg,
                        productType = it.productType
                    )
                }
        )
    }
}