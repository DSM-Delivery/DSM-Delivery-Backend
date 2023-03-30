package com.dsmdeliverybackend.domain.conclusion.service

import com.dsmdeliverybackend.domain.conclusion.facade.ConclusionFacade
import com.dsmdeliverybackend.domain.conclusion.presentation.response.QueryConclusionResponse
import com.dsmdeliverybackend.domain.post.facade.PostFacade
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class QueryConclusionService (
    private val conclusionFacade: ConclusionFacade,
    private val postFacade: PostFacade
) {

    fun execute(postId: UUID): QueryConclusionResponse {
        println(1)
        val conclusion = conclusionFacade.findByPostId(postId)

        println(conclusion)
        val post = postFacade.getPostByUUID(postId)

        return QueryConclusionResponse(
            userName = post.user.userName,
            cost = post.cost,
            location = post.location,
            riderRequest = post.riderRequest,
            postType = post.postType,
            receiver = conclusion.user.userName
        )
    }
}