package com.dsmdeliverybackend.domain.post.domain.repository

import com.dsmdeliverybackend.domain.conclusion.domain.QConclusionEntity.conclusionEntity
import com.dsmdeliverybackend.domain.post.domain.QPost.post
import com.dsmdeliverybackend.domain.post.domain.repository.vo.*
import com.dsmdeliverybackend.domain.product.domain.QProductEntity.productEntity
import com.dsmdeliverybackend.domain.selection.domain.QSelectionEntity.selectionEntity
import com.dsmdeliverybackend.domain.user.domain.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*

class CustomPostRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomPostRepository {

    override fun queryOrderPostList(): List<QueryOrderPostVO> {

        return jpaQueryFactory
            .select(
                QQueryOrderPostVO(
                    post.title,
                    user.userName,
                    post.cost,
                    post.id,
                    user.profileImg,
                    user.star,
                    productEntity.productType
                )
            )
            .from(post)
            .innerJoin(post.user, user)
            .innerJoin(selectionEntity).on(selectionEntity.post.id.eq(post.id))
            .innerJoin(selectionEntity.productEntity, productEntity)
            .leftJoin(conclusionEntity).on(post.id.eq(conclusionEntity.post.id))
            .where(post.postType.eq("ORDER").and(conclusionEntity.post.id.isNull))
            .distinct()
            .fetch().toList()
    }

    override fun queryRiderPostList(): List<QueryRiderPostVO> {

        return jpaQueryFactory
            .select(
                QQueryRiderPostVO(
                    post.title,
                    user.userName,
                    post.cost,
                    post.id,
                    user.profileImg,
                    user.star
                )
            )
            .from(post)
            .innerJoin(post.user, user).on(post.user.id.eq(user.id))
            .leftJoin(conclusionEntity).on(post.id.eq(conclusionEntity.post.id))
            .where(post.postType.eq("RIDER").and(conclusionEntity.post.id.isNull))
            .fetch().toList()
    }

    override fun queryPostDetail(postId: UUID): QueryPostDetailVO {
        return jpaQueryFactory
            .select(
                QQueryPostDetailVO(
                    post.title,
                    post.content,
                    post.cost,
                    post.location,
                    post.riderRequest,
                    user.userName,
                    user.profileImg,
                    user.star,
                    productEntity.productType
                )
            )
            .from(post)
            .innerJoin(post.user, user)
            .on(post.user.id.eq(user.id))
            .innerJoin(selectionEntity).on(selectionEntity.post.id.eq(post.id))
            .innerJoin(selectionEntity.productEntity, productEntity)
            .where(post.id.eq(postId))
            .fetchFirst()
    }
}