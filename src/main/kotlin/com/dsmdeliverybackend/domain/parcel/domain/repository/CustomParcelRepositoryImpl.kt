package com.dsmdeliverybackend.domain.parcel.domain.repository

import com.dsmdeliverybackend.domain.parcel.domain.QParcel.parcel
import com.dsmdeliverybackend.domain.parcel.domain.repository.vo.QQueryParcelVO
import com.dsmdeliverybackend.domain.parcel.domain.repository.vo.QueryParcelVO
import com.dsmdeliverybackend.domain.user.domain.QUser.user
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomParcelRepositoryImpl (
    private val jpaQueryFactory: JPAQueryFactory
) : CustomParcelRepository {

    override fun queryParcelList(): List<QueryParcelVO> {
        return jpaQueryFactory
            .select(
                QQueryParcelVO(
                    parcel.productId,
                    user.userName,
                    user.phoneNumber,
                    parcel.receive
                )
            )
            .from(parcel)
            .where(parcel.receive.isFalse)
            .fetch().toList()

    }
}