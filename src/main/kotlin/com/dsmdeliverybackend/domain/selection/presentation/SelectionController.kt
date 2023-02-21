package com.dsmdeliverybackend.domain.selection.presentation

import com.dsmdeliverybackend.domain.selection.presentation.dto.request.CreateSelectionRequest
import com.dsmdeliverybackend.domain.selection.presentation.dto.response.QuerySelectionResponse
import com.dsmdeliverybackend.domain.selection.service.CreateSelectionService
import com.dsmdeliverybackend.domain.selection.service.QuerySelectionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/selection")
@RestController
class SelectionController (
    private val createSelectionService: CreateSelectionService,
    private val querySelectionService: QuerySelectionService
) {

    @PostMapping
    fun createSelection(@RequestBody request: CreateSelectionRequest) {
        createSelectionService.execute(request)
    }

    @GetMapping("/{post-id}")
    fun querySelectionList(@PathVariable("post-id") postId: UUID, @RequestParam productType: String): QuerySelectionResponse {
        return querySelectionService.execute(postId, productType)
    }
}