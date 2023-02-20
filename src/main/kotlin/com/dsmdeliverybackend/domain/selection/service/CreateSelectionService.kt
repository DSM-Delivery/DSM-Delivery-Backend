package com.dsmdeliverybackend.domain.selection.service

import com.dsmdeliverybackend.domain.post.facade.PostFacade
import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.domain.product.facade.ProductFacade
import com.dsmdeliverybackend.domain.selection.domain.SelectionEntity
import com.dsmdeliverybackend.domain.selection.domain.SelectionEntityId
import com.dsmdeliverybackend.domain.selection.facade.SelectionFacade
import com.dsmdeliverybackend.domain.selection.presentation.dto.request.CreateSelectionRequest
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CreateSelectionService (
    private val selectionFacade: SelectionFacade,
    private val userFacade: UserFacade,
    private val postFacade: PostFacade,
    private val productFacade: ProductFacade
) {

    fun execute(request: CreateSelectionRequest) {
        val user = userFacade.getCurrentUser()

        val post = postFacade.getPostByUUID(request.postId)

        val selectionEntityList = request.selectionList
            .map {
                SelectionEntity(
                    Id = SelectionEntityId(
                        post = post.id,
                        product = it.productId
                    ),
                    post,
                    ProductEntity(
                        id = it.productId,
                        productType = it.productType
                    ),
                    quantity = it.quantity
                )
            }

        selectionFacade.saveAllSelection(selectionEntityList)
    }
}