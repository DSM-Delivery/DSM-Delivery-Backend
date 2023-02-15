package com.dsmdeliverybackend.domain.selection.domain.repository

import com.dsmdeliverybackend.domain.selection.domain.SelectionEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface SelectionRepository : CrudRepository<SelectionEntity, UUID>