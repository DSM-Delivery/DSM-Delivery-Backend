package com.dsmdeliverybackend.domain.conclusion.domain

import com.dsmdeliverybackend.domain.post.domain.Post
import com.dsmdeliverybackend.domain.user.domain.User
import javax.persistence.*
import javax.validation.constraints.NotNull

@Table(name = "tbl_conclusion")
@Entity
class ConclusionEntity (

    @EmbeddedId
    var id: ConclustionEntityId,

    @MapsId("user")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)")
    @field:NotNull
    val user: User,

    @MapsId("post")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", columnDefinition = "BINARY(16)")
    @field:NotNull
    val post: Post

)