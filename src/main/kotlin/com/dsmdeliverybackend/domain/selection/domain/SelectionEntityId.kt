package com.dsmdeliverybackend.domain.selection.domain

import java.io.Serializable
import java.util.UUID
import javax.persistence.*

@Embeddable
class SelectionEntityId(
    @Column(nullable = false)
    val post: UUID,

    @Column(nullable = false)
    val product: UUID
) : Serializable
