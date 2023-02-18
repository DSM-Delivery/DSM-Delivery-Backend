package com.dsmdeliverybackend.domain.post.domain.repository

import com.dsmdeliverybackend.domain.post.domain.repository.vo.QueryPostVO

interface CustomPostRepository {
    fun queryPostList(): List<QueryPostVO>
}