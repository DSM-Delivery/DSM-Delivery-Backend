package com.dsmdeliverybackend.domain.snack.domain.repository

import com.dsmdeliverybackend.domain.snack.domain.Snack
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SnackRepository : CrudRepository<Snack, UUID> {

    fun existsBySnackName(snackName: String): Boolean
}