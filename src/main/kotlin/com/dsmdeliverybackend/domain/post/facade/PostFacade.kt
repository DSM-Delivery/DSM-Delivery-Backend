package com.dsmdeliverybackend.domain.post.facade

import com.dsmdeliverybackend.domain.post.domain.Post
import com.dsmdeliverybackend.domain.post.domain.repository.PostRepository
import com.dsmdeliverybackend.domain.post.presentation.dto.request.CreatePostRequest
import com.dsmdeliverybackend.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
class PostFacade(
    private val postRepository: PostRepository
) {

    fun savePost(request: CreatePostRequest, user: User) {
        postRepository.save(
            Post(
                title = request.title,
                content = request.content,
                cost = request.cost,
                postType = request.postType,
                isFinished = false,
                isChecked = false,
                user = user
        ))
    }

}