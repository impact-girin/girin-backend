package com.girin.girinbackend.domain.service

import com.girin.girinbackend.domain.controller.dto.response.GuestBookList
import com.girin.girinbackend.domain.repository.GuestBookRepository
import org.springframework.stereotype.Service

@Service
class GuestBookService(
    private val guestBookRepository: GuestBookRepository,
) {

    fun getGuestBookList(): GuestBookList {
        val guestBookList = guestBookRepository.findAll()

        val response = guestBookList.map { guestBook ->
            GuestBookList.GuestBookElement(
                userName = guestBook.user.name,
                mountainName = guestBook.mountain.name,
                mountainImageUrl = guestBook.mountain.mountainImageUrl,
            )
        }

        return GuestBookList(response)
    }
}
