package com.dsmdeliverybackend.domain.conclusion.domain

import java.io.Serializable
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ConclusionEntityId (

    @Column(nullable = false)
    val user: UUID,

    @Column(nullable = false)
    val post: UUID

) : Serializable