package com.dsmdeliverybackend.domain.conclusion.service

import com.dsmdeliverybackend.domain.conclusion.domain.repository.ConclusionRepository
import com.dsmdeliverybackend.domain.conclusion.presentation.response.ConclusionNoticeResponse
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class ConclusionNoticeService (
    private val userFacade: UserFacade,
    private val conclusionRepository: ConclusionRepository
) {

    fun execute(): ConclusionNoticeResponse {
        val user = userFacade.getCurrentUser()

        val isFinished = conclusionRepository.QueryConclusionNotice(user.id)

        return ConclusionNoticeResponse(
            isFinished = isFinished.isFinished
        )
    }
}