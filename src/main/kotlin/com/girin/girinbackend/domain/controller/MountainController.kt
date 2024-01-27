package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.domain.controller.dto.response.MountainList
import com.girin.girinbackend.domain.service.MountainService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/mountain")
@RestController
class MountainController(
    private val mountainService: MountainService,
) {
    @GetMapping
    fun getMountainListByName(
        @RequestParam("name") name: String,
    ): MountainList {
        return mountainService.getMountainListByName(name)
    }
}
