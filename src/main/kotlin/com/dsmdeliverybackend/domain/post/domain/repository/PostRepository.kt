package com.dsmdeliverybackend.domain.post.domain.repository

import com.dsmdeliverybackend.domain.post.domain.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PostRepository : CrudRepository<Post, UUID>, CustomPostRepository {
}