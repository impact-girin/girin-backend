package com.girin.girinbackend.domain.service

import com.girin.girinbackend.domain.controller.dto.response.ImageUrlResponse
import com.girin.girinbackend.infra.s3.S3Facade
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ImageService(
    private val s3Facade: S3Facade,
) {

    fun uploadImage(images: List<MultipartFile>) = ImageUrlResponse(images.map(s3Facade::uploadImage))
}
