package com.dsmdeliverybackend.domain.post.service

import com.dsmdeliverybackend.domain.post.facade.PostFacade
import com.dsmdeliverybackend.domain.post.presentation.dto.request.CreatePostRequest
import com.dsmdeliverybackend.domain.post.presentation.dto.response.PostUUIDResponse
import com.dsmdeliverybackend.domain.product.domain.ProductEntity
import com.dsmdeliverybackend.domain.selection.domain.SelectionEntity
import com.dsmdeliverybackend.domain.selection.domain.SelectionEntityId
import com.dsmdeliverybackend.domain.selection.facade.SelectionFacade
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CreatePostService (
    private val userFacade: UserFacade,
    private val postFacade: PostFacade,
) {

    fun execute(request: CreatePostRequest): PostUUIDResponse {
        val user = userFacade.getCurrentUser()

        val post = postFacade.savePost(request, user)

        return PostUUIDResponse(
            postId = post.id
        )
    }

}