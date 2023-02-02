package com.dsmdeliverybackend.domain.post.service

import com.dsmdeliverybackend.domain.post.facade.PostFacade
import com.dsmdeliverybackend.domain.post.presentation.dto.request.CreatePostRequest
import com.dsmdeliverybackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class CreatePostService (
    private val userFacade: UserFacade,
    private val postFacade: PostFacade
) {

    fun execute(request: CreatePostRequest) {
        val user = userFacade.getCurrentUser()

        postFacade.savePost(request, user)
    }

}