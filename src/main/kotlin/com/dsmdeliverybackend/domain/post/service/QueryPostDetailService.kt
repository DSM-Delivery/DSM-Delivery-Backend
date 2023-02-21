package com.dsmdeliverybackend.domain.post.service

import com.dsmdeliverybackend.domain.post.domain.repository.PostRepository
import com.dsmdeliverybackend.domain.post.presentation.dto.response.QueryPostDetailResponse
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class QueryPostDetailService (
    private val postRepository: PostRepository,
) {

    fun execute(postId: UUID): QueryPostDetailResponse {
        val postDetail = postRepository.queryPostDetail(postId)

        return QueryPostDetailResponse(
            title = postDetail.title,
            content = postDetail.content,
            userName = postDetail.userName,
            profileImg = postDetail.profileImg,
            cost = postDetail.cost,
            star = postDetail.star
        )
    }
}