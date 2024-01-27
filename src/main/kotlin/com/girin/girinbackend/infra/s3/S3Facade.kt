package com.girin.girinbackend.infra.s3

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.girin.girinbackend.common.exception.SaveImageFailedException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@Component
class S3Facade(
    @Value("\${spring.cloud.aws.s3.bucket}")
    val bucketName: String,

    private val amazonS3Client: AmazonS3Client,
) {
    fun uploadImage(image: MultipartFile): String {
        val fileName = "${UUID.randomUUID()}${image.originalFilename}"

        runCatching {
            val putObjectRequest = PutObjectRequest(
                bucketName,
                fileName,
                image.inputStream,
                getObjectMetadata(image),
            )
            amazonS3Client.putObject(putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead))
        }.onFailure {
            it.printStackTrace()
            throw SaveImageFailedException
        }

        return amazonS3Client.getUrl(bucketName, fileName).toString()
    }

    private fun getObjectMetadata(image: MultipartFile) = ObjectMetadata().apply {
        contentLength = image.size
        contentType = image.contentType
    }
}
