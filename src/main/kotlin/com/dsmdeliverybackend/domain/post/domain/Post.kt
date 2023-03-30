package com.dsmdeliverybackend.domain.post.domain

import com.dsmdeliverybackend.domain.user.domain.User
import com.dsmdeliverybackend.global.entity.BaseUUIDEntity
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_post")
class Post (

    id: UUID ?= null,

    title: String,

    content: String,

    cost: String,

    @field: NotNull
    val postType: String,

    isFinished: Boolean,

    isChecked: Boolean,

    location: String,

    riderRequest: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

) :BaseUUIDEntity(id) {

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    var title = title
        protected set

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    var content = content

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(5)")
    var cost = cost

    @field:NotNull
    @Column(columnDefinition = "BIT(1)")
    var isFinished = isFinished

    @field:NotNull
    @Column(columnDefinition = "BIT(1)")
    var isChecked = isChecked

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(15)")
    var location = location

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(50)")
    var riderRequest = riderRequest

    fun deliveryComplete(request: Boolean) {
        this.isFinished = request
    }

}