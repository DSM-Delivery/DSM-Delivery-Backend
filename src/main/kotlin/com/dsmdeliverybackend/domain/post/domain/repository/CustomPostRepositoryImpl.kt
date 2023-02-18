package com.dsmdeliverybackend.domain.post.domain.repository

import com.dsmdeliverybackend.domain.post.domain.QPost.post
import com.dsmdeliverybackend.domain.post.domain.repository.vo.QQueryPostVO
import com.dsmdeliverybackend.domain.post.domain.repository.vo.QueryPostVO
import com.dsmdeliverybackend.domain.user.domain.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomPostRepositoryImpl (
    private val jpaQueryFactory: JPAQueryFactory
) : CustomPostRepository {

    override fun queryPostList(): List<QueryPostVO> {
        return jpaQueryFactory
            .select(
                QQueryPostVO(
                    post.title,
                    user.userName,
                    post.cost,
                    post.id,
                    user.profileImg,
                    user.star,
                    post.postType
                )
            )
            .from(post)
            .where(post.isFinished.isFalse)
            .fetch().toList()
    }
}