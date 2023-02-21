package com.dsmdeliverybackend.domain.post.service

import com.dsmdeliverybackend.domain.post.domain.repository.PostRepository
import com.dsmdeliverybackend.domain.post.presentation.dto.response.RiderPostListResponse
import com.dsmdeliverybackend.domain.post.presentation.dto.response.RiderResponse
import org.springframework.stereotype.Service

@Service
class QueryRiderPostListService (
    private val postRepository: PostRepository
) {

    fun execute(): RiderPostListResponse {

        val riderList = postRepository.queryRiderPostList()

        return RiderPostListResponse(
            postList = riderList
                .map {
                    RiderResponse(
                        title = it.title,
                        userName = it.userName,
                        cost = it.cost,
                        postId = it.postId,
                        profileImg = it.profileImg,
                        star = it.star
                    )
                }
        )
    }
}