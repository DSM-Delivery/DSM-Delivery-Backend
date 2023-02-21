package com.dsmdeliverybackend.domain.selection.service

import com.dsmdeliverybackend.domain.selection.domain.repository.SelectionRepository
import com.dsmdeliverybackend.domain.selection.facade.SelectionFacade
import com.dsmdeliverybackend.domain.selection.presentation.dto.response.QuerySelectionResponse
import com.dsmdeliverybackend.domain.selection.presentation.dto.response.SelectionResponse
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class QuerySelectionService (
    private val selectionRepository: SelectionRepository,
) {

    fun execute(postId: UUID, productType: String): QuerySelectionResponse {

        val selectionList = selectionRepository.querySelectionList(postId, productType)

        return QuerySelectionResponse (
            selectionList = selectionList
                .map {
                    SelectionResponse(
                        productName = it.productName,
                        quantity = it.quantity
                    )
                }
        )
    }
}