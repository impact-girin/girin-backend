package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.domain.controller.dto.response.ImageUrlResponse
import com.girin.girinbackend.domain.service.ImageService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/image")
@RestController
class ImageController(
    private val imageService: ImageService,
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun saveImage(@RequestPart images: List<MultipartFile>): ImageUrlResponse {
        return imageService.uploadImage(images)
    }
}
