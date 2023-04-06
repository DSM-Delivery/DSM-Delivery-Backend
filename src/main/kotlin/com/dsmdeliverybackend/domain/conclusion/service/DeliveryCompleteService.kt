package com.dsmdeliverybackend.domain.conclusion.service

import com.dsmdeliverybackend.domain.conclusion.facade.ConclusionFacade
import com.dsmdeliverybackend.domain.post.facade.PostFacade
import org.springframework.stereotype.Service
import java.util.UUID
import javax.transaction.Transactional

@Service
class DeliveryCompleteService (
    private val conclusionFacade: ConclusionFacade
) {

    @Transactional
    fun execute(postId: UUID) {
        val conclusionEntity = conclusionFacade.findByPostId(postId)

        conclusionEntity.deliveryComplete(true)
    }
}