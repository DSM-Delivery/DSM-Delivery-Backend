package com.dsmdeliverybackend.domain.conclusion.domain.repository

import com.dsmdeliverybackend.domain.conclusion.domain.ConclusionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ConclusionRepository : CrudRepository<ConclusionEntity, UUID> {
    fun findByPostId(postId: UUID): ConclusionEntity?
}