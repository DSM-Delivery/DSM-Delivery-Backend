package com.dsmdeliverybackend.domain.image.presentation

import com.dsmdeliverybackend.domain.image.presentation.response.ImageUrlResponse
import com.dsmdeliverybackend.domain.image.service.UploadImageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/images")
@RestController
class ImageController (
    private val uploadImageService: UploadImageService
) {

    @PostMapping
    fun uploadImage(@RequestPart("images") multipartFile: MultipartFile): ImageUrlResponse {
        return uploadImageService.execute(multipartFile)
    }

}