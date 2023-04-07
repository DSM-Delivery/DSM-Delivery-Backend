package com.dsmdeliverybackend.domain.conclusion.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection

class ConclusionNoticeVO @QueryProjection constructor (
    val isFinished: Boolean
)