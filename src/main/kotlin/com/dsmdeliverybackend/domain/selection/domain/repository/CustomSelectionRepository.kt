package com.dsmdeliverybackend.domain.selection.domain.repository

import com.dsmdeliverybackend.domain.selection.domain.repository.vo.QuerySelectionVO
import java.util.UUID

interface CustomSelectionRepository {
    fun querySelectionList(postId: UUID, productType: String): List<QuerySelectionVO>
}