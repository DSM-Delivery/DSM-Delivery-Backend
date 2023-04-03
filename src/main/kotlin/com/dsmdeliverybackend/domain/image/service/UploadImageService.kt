package com.dsmdeliverybackend.domain.image.service
import com.dsmdeliverybackend.domain.image.presentation.response.ImageUrlResponse
import com.dsmdeliverybackend.infrastructure.s3.S3Facade
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UploadImageService (
    private val s3Facade: S3Facade
) {

    fun execute(images: MultipartFile): ImageUrlResponse {
        val imageUrl =  s3Facade.uploadImage(images)

        return ImageUrlResponse(imageUrl)
    }

}