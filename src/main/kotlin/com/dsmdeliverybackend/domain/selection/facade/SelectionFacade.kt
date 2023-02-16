package com.dsmdeliverybackend.domain.selection.facade

import com.dsmdeliverybackend.domain.selection.domain.SelectionEntity
import com.dsmdeliverybackend.domain.selection.domain.repository.SelectionRepository
import org.springframework.stereotype.Component

@Component
class SelectionFacade (
    private val selectionRepository: SelectionRepository
) {
    fun saveAllSelection(selectionList: List<SelectionEntity>) {
        selectionRepository.saveAll(selectionList)
    }
}