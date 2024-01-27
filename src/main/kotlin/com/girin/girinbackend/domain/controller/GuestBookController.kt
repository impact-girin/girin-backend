package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.domain.controller.dto.response.GuestBookList
import com.girin.girinbackend.domain.service.GuestBookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/guestbook")
@RestController
class GuestBookController(
    private val guestBookService: GuestBookService,
) {

    @GetMapping("/list")
    fun getGuestBookList(
        @RequestParam("mountain-name") name: String,
    ): GuestBookList {
        return guestBookService.getGuestBookList(name)
    }

    @PostMapping("/add/{mountain-id}")
    fun createGuestBook(
        @PathVariable("mountain-id") mountainId: Long,
    ) {
        guestBookService.createGuestBook(mountainId)
    }
}
