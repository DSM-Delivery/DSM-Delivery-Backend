package com.dsmdeliverybackend.domain.selection.presentation

import com.dsmdeliverybackend.domain.selection.presentation.dto.request.CreateSelectionRequest
import com.dsmdeliverybackend.domain.selection.service.CreateSelectionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/selection")
@RestController
class SelectionController (
    private val createSelectionService: CreateSelectionService
) {

    @PostMapping
    fun createSelection(@RequestBody request: CreateSelectionRequest) {
        createSelectionService.execute(request)
    }
}