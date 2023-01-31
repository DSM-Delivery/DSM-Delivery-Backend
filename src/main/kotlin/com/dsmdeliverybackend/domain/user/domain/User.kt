package com.dsmdeliverybackend.domain.user.domain

import com.dsmdeliverybackend.global.entity.BaseUUIDEntity
import com.dsmdeliverybackend.global.enum.Role
import com.dsmdeliverybackend.global.enum.Sex
import org.jetbrains.annotations.NotNull
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "tbl_user")
class User (

    id: UUID? = null,

    accountId: String,

    password: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val userName: String,

    star: Int,

    profileImg: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(11)")
    val phoneNumber: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(6)")
    val sex: Sex,

    canDriver: Boolean,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(7)")
    val role: Role

) : BaseUUIDEntity(id) {

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    var accountId = accountId
        protected set

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(60)")
    var password = password
        protected set

    @field:NotNull
    @Column(columnDefinition = "BIT(1)")
    var canDriver = canDriver
        protected set

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(5)")
    var star = star
        protected set

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    var profileImg = profileImg
        protected set

}