package com.dsmdeliverybackend.domain.snack.service

import com.dsmdeliverybackend.domain.snack.domain.repository.SnackRepository
import com.dsmdeliverybackend.domain.snack.facade.SnackFacade
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeleteSnackService (
    private val snackRepository: SnackRepository,
    private val snackFacade: SnackFacade
) {

    fun execute(snackId: UUID) {
        val snack = snackFacade.getSnackBySnackId(snackId)

        snackRepository.delete(snack)
    }

}