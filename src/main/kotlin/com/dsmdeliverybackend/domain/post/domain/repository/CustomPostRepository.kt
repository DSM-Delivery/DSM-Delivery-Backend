package com.dsmdeliverybackend.domain.post.domain.repository

import com.dsmdeliverybackend.domain.post.domain.repository.vo.QueryOrderPostVO
import com.dsmdeliverybackend.domain.post.domain.repository.vo.QueryPostDetailVO
import com.dsmdeliverybackend.domain.post.domain.repository.vo.QueryRiderPostVO
import java.util.UUID

interface CustomPostRepository {
    fun queryOrderPostList(): List<QueryOrderPostVO>

    fun queryRiderPostList(): List<QueryRiderPostVO>

    fun queryPostDetail(postId: UUID): QueryPostDetailVO
}