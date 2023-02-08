package com.dsmdeliverybackend.domain.snack.presentation

import com.dsmdeliverybackend.domain.snack.presentation.dto.request.AddSnackRequest
import com.dsmdeliverybackend.domain.snack.presentation.dto.response.SnackListResponse
import com.dsmdeliverybackend.domain.snack.service.AddSnackService
import com.dsmdeliverybackend.domain.snack.service.DeleteSnackService
import com.dsmdeliverybackend.domain.snack.service.QuerySnackListService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/vending-machine")
@RestController
class SnackController (
    private val addSnackService: AddSnackService,
    private val deleteSnackService: DeleteSnackService,
    private val querySnackListService: QuerySnackListService
) {

    @PostMapping
    fun addSnack(@RequestBody request: AddSnackRequest) {
        addSnackService.execute(request)
    }

    @DeleteMapping("/{snack-id}")
    fun deleteSnack(@PathVariable("snack-id") snackId: UUID) {
        deleteSnackService.execute(snackId)
    }

    @GetMapping("/list")
    fun snackList(): SnackListResponse {
        return querySnackListService.execute()
    }

}