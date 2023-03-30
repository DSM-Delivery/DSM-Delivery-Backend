package com.dsmdeliverybackend.domain.conclusion.presentation

import com.dsmdeliverybackend.domain.conclusion.presentation.response.QueryConclusionResponse
import com.dsmdeliverybackend.domain.conclusion.service.CreateConclusionService
import com.dsmdeliverybackend.domain.conclusion.service.QueryConclusionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/conclusion")
@RestController
class ConclusionController (
    private val createConclusionService: CreateConclusionService,
    private val queryConclusionService: QueryConclusionService
) {

    @PostMapping("/{post-id}")
    fun createConclusion(@PathVariable("post-id") postId: UUID) {
        createConclusionService.execute(postId)
    }

    @GetMapping("/{post-id}")
    fun queryConclusion(@PathVariable("post-id") postId: UUID): QueryConclusionResponse {
        return queryConclusionService.execute(postId)
    }

}