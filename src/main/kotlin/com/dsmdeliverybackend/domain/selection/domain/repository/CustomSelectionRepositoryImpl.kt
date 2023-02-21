package com.dsmdeliverybackend.domain.selection.domain.repository

import com.dsmdeliverybackend.domain.parcel.domain.QParcel.parcel
import com.dsmdeliverybackend.domain.product.domain.QProductEntity.productEntity
import com.dsmdeliverybackend.domain.selection.domain.QSelectionEntity.selectionEntity
import com.dsmdeliverybackend.domain.selection.domain.repository.vo.QQuerySelectionVO
import com.dsmdeliverybackend.domain.selection.domain.repository.vo.QuerySelectionVO
import com.dsmdeliverybackend.domain.snack.domain.QSnack.snack
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*

class CustomSelectionRepositoryImpl (
    private val jpaQueryFactory: JPAQueryFactory
) : CustomSelectionRepository {

    override fun querySelectionList(postId: UUID, productType: String): List<QuerySelectionVO> {

        if (productType == "snack") {
            return jpaQueryFactory
                .select(
                    QQuerySelectionVO(
                        snack.snackName,
                        selectionEntity.quantity
                    )
                )
                .from(selectionEntity)
                .leftJoin(selectionEntity.productEntity, productEntity)
                .leftJoin(snack).on(snack.productEntity.id.eq(productEntity.id))
                .where(selectionEntity.post.id.eq(postId))
                .fetch().toList()
        }

        else {
            return jpaQueryFactory
                .select(
                    QQuerySelectionVO(
                        parcel.parcelName,
                        selectionEntity.quantity
                    )
                )
                .from(selectionEntity)
                .leftJoin(selectionEntity.productEntity, productEntity)
                .leftJoin(parcel).on(parcel.productEntity.id.eq(productEntity.id))
                .where(selectionEntity.post.id.eq(postId))
                .fetch().toList()
        }
    }
}