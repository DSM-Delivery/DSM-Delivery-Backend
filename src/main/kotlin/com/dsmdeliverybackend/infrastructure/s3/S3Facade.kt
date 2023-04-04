package com.dsmdeliverybackend.infrastructure.s3

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.dsmdeliverybackend.global.exception.ImageNotFoundException
import com.dsmdeliverybackend.infrastructure.s3.S3Properties
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Component
class S3Facade (
    private val s3Properties: S3Properties,
    private val amazonS3: AmazonS3
) {

    fun uploadImage(image: MultipartFile): String {
        if (image.isEmpty())
            throw ImageNotFoundException

        val s3FileName: String = UUID.randomUUID().toString()

        try {
            amazonS3.putObject(
                PutObjectRequest(
                    s3Properties.bucket,
                    s3FileName,
                    image.inputStream,
                    getObjectMetadata(image)
                ).withCannedAcl(CannedAccessControlList.PublicRead)
            )
        } catch (e: Exception) {
            println(e.cause)
            println(e.message)
        }

        return getFileUrl(s3FileName)
    }

    private fun getObjectMetadata(image: MultipartFile): ObjectMetadata {
        val objectMetadata = ObjectMetadata()
        objectMetadata.contentLength = image.size
        objectMetadata.contentType = image.contentType

        return objectMetadata
    }

    fun getFileUrl(s3FileName: String): String {
        return amazonS3.getUrl(s3Properties.bucket, s3FileName).toString()
    }

}