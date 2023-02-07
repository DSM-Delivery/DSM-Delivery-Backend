package com.dsmdeliverybackend.domain.snack.facade

import com.dsmdeliverybackend.domain.snack.domain.Snack
import com.dsmdeliverybackend.domain.snack.domain.repository.SnackRepository
import com.dsmdeliverybackend.domain.snack.exception.SnackNotFoundException
import com.dsmdeliverybackend.domain.snack.presentation.dto.request.AddSnackRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SnackFacade (
    private val snackRepository: SnackRepository
) {

    fun isAlreadyExist(snackName: String): Boolean {
        return snackRepository.existsBySnackName(snackName)
    }

    fun saveSnack(request: AddSnackRequest) {
        snackRepository.save(
            Snack(
                snackName = request.snackName,
                price = request.price,
                snackType = request.snackType
            )
        )
    }

    fun getSnackBySnackId(snackId: UUID): Snack {
        return snackRepository.findByIdOrNull(snackId) ?: throw SnackNotFoundException
    }

}