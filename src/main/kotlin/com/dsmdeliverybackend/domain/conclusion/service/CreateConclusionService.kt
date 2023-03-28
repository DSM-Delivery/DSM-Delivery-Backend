package com.dsmdeliverybackend.domain.conclusion.service

import com.dsmdeliverybackend.domain.conclusion.facade.ConclusionFacade
import com.dsmdeliverybackend.domain.post.facade.PostFacade
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreateConclusionService (
    private val userFacade: UserFacade,
    private val postFacade: PostFacade,
    private val conclusionFacade: ConclusionFacade
) {

    fun execute(postId: UUID) {
        val user = userFacade.getCurrentUser()

        val post = postFacade.getPostByUUID(postId)

        conclusionFacade.saveConclusion(user, post)

    }
}