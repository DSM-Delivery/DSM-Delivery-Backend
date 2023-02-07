package com.dsmdeliverybackend.domain.snack.service

import com.dsmdeliverybackend.domain.snack.exception.SnackAlreadyExistException
import com.dsmdeliverybackend.domain.snack.facade.SnackFacade
import com.dsmdeliverybackend.domain.snack.presentation.dto.request.AddSnackRequest
import org.springframework.stereotype.Service

@Service
class AddSnackService (
    private val snackFacade: SnackFacade
) {

    fun execute(request: AddSnackRequest) {

        if (snackFacade.isAlreadyExist(request.snackName)) {
            throw SnackAlreadyExistException
        }

        snackFacade.saveSnack(request)
    }

}