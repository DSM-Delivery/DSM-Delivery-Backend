package com.dsmdeliverybackend.domain.conclusion.domain.repository

import com.dsmdeliverybackend.domain.conclusion.domain.QConclusionEntity.conclusionEntity
import com.dsmdeliverybackend.domain.conclusion.domain.repository.vo.ConclusionNoticeVO
import com.dsmdeliverybackend.domain.conclusion.domain.repository.vo.QConclusionNoticeVO
import com.dsmdeliverybackend.domain.post.domain.QPost.post
import com.dsmdeliverybackend.domain.user.domain.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*

class CustomConclusionRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomConclusionRepository {

    override fun QueryConclusionNotice(userId: UUID): ConclusionNoticeVO {

        return jpaQueryFactory
            .select(
                QConclusionNoticeVO(
                    conclusionEntity.isFinished
                )
            )
            .from(conclusionEntity)
            .innerJoin(conclusionEntity.user, user)
            .innerJoin(conclusionEntity.post, post)
            .where(conclusionEntity.user.id.eq(userId).or(post.user.id.eq(userId)))
            .fetchFirst()
    }
}