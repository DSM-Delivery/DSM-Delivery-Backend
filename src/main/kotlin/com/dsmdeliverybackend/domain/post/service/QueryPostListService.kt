package com.dsmdeliverybackend.domain.post.service

import com.dsmdeliverybackend.domain.post.domain.repository.PostRepository
import com.dsmdeliverybackend.domain.post.presentation.dto.response.PostListResponse
import com.dsmdeliverybackend.domain.post.presentation.dto.response.PostResponse
import org.springframework.stereotype.Service

@Service
class QueryPostListService (
    private val postRepository: PostRepository
) {

    fun execute(): PostListResponse {
        val postList = postRepository.queryPostList()

        return PostListResponse(
            postList =  postList
                .map {
                    PostResponse(
                        title = it.title,
                        userName = it.userName,
                        cost = it.cost,
                        postId = it.postId,
                        profileImg = it.profileImg,
                        star = it.star,
                        postType = it.postType
                    )
                }
        )
    }
}