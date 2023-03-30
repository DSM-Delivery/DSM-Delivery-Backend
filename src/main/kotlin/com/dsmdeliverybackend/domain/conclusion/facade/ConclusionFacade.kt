package com.dsmdeliverybackend.domain.conclusion.facade

import com.dsmdeliverybackend.domain.conclusion.domain.ConclusionEntity
import com.dsmdeliverybackend.domain.conclusion.domain.ConclusionEntityId
import com.dsmdeliverybackend.domain.conclusion.domain.repository.ConclusionRepository
import com.dsmdeliverybackend.domain.conclusion.exception.ConclusionNotFoundException
import com.dsmdeliverybackend.domain.post.domain.Post
import com.dsmdeliverybackend.domain.user.domain.User
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ConclusionFacade (
    private val conclusionRepository: ConclusionRepository
) {

    fun saveConclusion(user: User, post: Post) {
        conclusionRepository.save(
            ConclusionEntity(
                id = ConclusionEntityId(
                    user = user.id,
                    post = post.id
                ),
                user = user,
                post = post
        ))
    }

    fun findByPostId(postId: UUID): ConclusionEntity {
        return conclusionRepository.findByPostId(postId) ?: throw ConclusionNotFoundException
    }

}