package com.dsmdeliverybackend.domain.post.domain.repository

import com.dsmdeliverybackend.domain.post.domain.QPost
import com.dsmdeliverybackend.domain.post.domain.QPost.post
import com.dsmdeliverybackend.domain.post.domain.repository.vo.QQueryPostDetailVO
import com.dsmdeliverybackend.domain.post.domain.repository.vo.QQueryPostVO
import com.dsmdeliverybackend.domain.post.domain.repository.vo.QueryPostDetailVO
import com.dsmdeliverybackend.domain.post.domain.repository.vo.QueryPostVO
import com.dsmdeliverybackend.domain.product.domain.QProductEntity
import com.dsmdeliverybackend.domain.product.domain.QProductEntity.productEntity
import com.dsmdeliverybackend.domain.selection.domain.QSelectionEntity
import com.dsmdeliverybackend.domain.selection.domain.QSelectionEntity.selectionEntity
import com.dsmdeliverybackend.domain.user.domain.QUser
import com.dsmdeliverybackend.domain.user.domain.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.transaction.annotation.Transactional
import java.util.*

class CustomPostRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : CustomPostRepository {

    override fun queryOrderPostList(): List<QueryPostVO> {

        return jpaQueryFactory
            .select(
                QQueryPostVO(
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
            .where(post.isFinished.isFalse, post.postType.eq("ORDER"))
            .distinct()
            .fetch().toList()
    }

    override fun queryPostDetail(postId: UUID): QueryPostDetailVO {
        return jpaQueryFactory
            .select(
                QQueryPostDetailVO(
                    post.title,
                    post.content,
                    post.cost,
                    user.userName,
                    user.profileImg,
                    user.star
                )
            )
            .from(post)
            .innerJoin(post.user, user)
            .on(post.user.id.eq(user.id))
            .where(post.id.eq(postId))
            .fetchFirst()
    }
}