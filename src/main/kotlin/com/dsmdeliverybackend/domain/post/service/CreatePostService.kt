package com.dsmdeliverybackend.domain.post.service

import com.dsmdeliverybackend.domain.post.facade.PostFacade
import com.dsmdeliverybackend.domain.post.presentation.dto.request.CreatePostRequest
import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.domain.selection.domain.SelectionEntity
import com.dsmdeliverybackend.domain.selection.domain.SelectionEntityId
import com.dsmdeliverybackend.domain.selection.facade.SelectionFacade
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CreatePostService (
    private val userFacade: UserFacade,
    private val postFacade: PostFacade,
    private val selectionFacade: SelectionFacade
) {

    fun execute(request: CreatePostRequest) {
        val user = userFacade.getCurrentUser()

        val post = postFacade.savePost(request, user)

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