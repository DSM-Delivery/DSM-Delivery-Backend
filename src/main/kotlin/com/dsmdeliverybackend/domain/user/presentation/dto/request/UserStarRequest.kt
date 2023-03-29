package com.dsmdeliverybackend.domain.user.presentation.dto.request

import org.jetbrains.annotations.NotNull
import java.util.UUID

class UserStarRequest (

    @field:NotNull
    val userId: UUID,

    @field:NotNull
    val star: Int

)