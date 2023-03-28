package com.dsmdeliverybackend.domain.conclusion.domain.repository

import com.dsmdeliverybackend.domain.conclusion.domain.ConclusionEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ConclusionRepository : CrudRepository<ConclusionEntity, UUID> {
}