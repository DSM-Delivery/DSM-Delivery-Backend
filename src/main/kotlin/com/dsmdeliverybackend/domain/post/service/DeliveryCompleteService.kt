package com.dsmdeliverybackend.domain.post.service

import com.dsmdeliverybackend.domain.post.facade.PostFacade
import org.springframework.stereotype.Service
import java.util.UUID
import javax.transaction.Transactional

@Service
class DeliveryCompleteService (
    private val postFacade: PostFacade
) {

    @Transactional
    fun execute(postId: UUID) {
        val post = postFacade.getPostByUUID(postId)

        post.deliveryComplete(true)
    }
}