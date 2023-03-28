package com.dsmdeliverybackend.domain.conclusion.facade

import com.dsmdeliverybackend.domain.conclusion.domain.ConclusionEntity
import com.dsmdeliverybackend.domain.conclusion.domain.ConclustionEntityId
import com.dsmdeliverybackend.domain.conclusion.domain.repository.ConclusionRepository
import com.dsmdeliverybackend.domain.post.domain.Post
import com.dsmdeliverybackend.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class ConclusionFacade (
    private val conclusionRepository: ConclusionRepository
) {

    fun saveConclusion(user: User, post: Post) {
        conclusionRepository.save(
            ConclusionEntity(
                id = ConclustionEntityId(
                    user = user.id,
                    post = post.id
                ),
                user = user,
                post = post
        ))
    }

}