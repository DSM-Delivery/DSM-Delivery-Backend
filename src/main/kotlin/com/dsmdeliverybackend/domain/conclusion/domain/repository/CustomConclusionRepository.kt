package com.dsmdeliverybackend.domain.conclusion.domain.repository

import com.dsmdeliverybackend.domain.conclusion.domain.repository.vo.ConclusionNoticeVO
import java.util.UUID

interface CustomConclusionRepository {
    fun QueryConclusionNotice(userId: UUID): ConclusionNoticeVO
}