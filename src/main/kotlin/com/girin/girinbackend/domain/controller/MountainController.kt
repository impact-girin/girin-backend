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
    @GetMapping("/list")
    fun getMountainList(): MountainList {
        return mountainService.getMountainList()
    }

    @GetMapping
    fun getMountainByName(
        @RequestParam("name") name: String,
    ): MountainList.MountainElement {
        return mountainService.getMountainByName(name)
    }
}
