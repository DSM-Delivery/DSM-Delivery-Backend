package com.dsmdeliverybackend.domain.snack.domain

import com.dsmdeliverybackend.global.entity.BaseUUIDEntity
import com.dsmdeliverybackend.global.enum.SnackType
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_snack")
class Snack (
    id: UUID ?= null,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(15)")
    val snackName: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(5)")
    val price: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(8)")
    val snackType : SnackType

) : BaseUUIDEntity(id)