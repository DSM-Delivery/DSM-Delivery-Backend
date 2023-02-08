package com.dsmdeliverybackend.domain.snack.service

import com.dsmdeliverybackend.domain.snack.domain.repository.SnackRepository
import com.dsmdeliverybackend.domain.snack.presentation.dto.response.SnackListResponse
import com.dsmdeliverybackend.domain.snack.presentation.dto.response.SnackResponse
import org.springframework.stereotype.Service

@Service
class QuerySnackListService (
    private val snackRepository: SnackRepository
) {

    fun execute(): SnackListResponse {
        val snackList = snackRepository.findAll()
            .map { SnackResponse(it) }
            .toList();

        return SnackListResponse(snackList);
    }
}