package com.dsmdeliverybackend.domain.conclusion.presentation

import com.dsmdeliverybackend.domain.conclusion.service.CreateConclusionService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/conclusion")
@RestController
class ConclusionController (
    private val createConclusionService: CreateConclusionService
) {

    @PostMapping("/{post-id}")
    fun createConclusion(@PathVariable("post-id") postId: UUID) {
        createConclusionService.execute(postId)
    }

}