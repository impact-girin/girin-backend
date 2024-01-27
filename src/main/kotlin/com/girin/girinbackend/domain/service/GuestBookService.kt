package com.girin.girinbackend.domain.service

import com.girin.girinbackend.common.exception.MountainNotFoundException
import com.girin.girinbackend.domain.controller.dto.response.GuestBookList
import com.girin.girinbackend.domain.entity.guestbook.GuestBook
import com.girin.girinbackend.domain.facade.UserFacade
import com.girin.girinbackend.domain.repository.GuestBookRepository
import com.girin.girinbackend.domain.repository.MountainRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GuestBookService(
    private val guestBookRepository: GuestBookRepository,
    private val mountainRepository: MountainRepository,
    private val userFacade: UserFacade,
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

    fun createGuestBook(mountainId: Long) {
        val user = userFacade.getCurrentUser()

        val mountain = mountainRepository.findByIdOrNull(mountainId)
            ?: throw MountainNotFoundException

        guestBookRepository.save(
            GuestBook(
                user = user,
                mountain = mountain,
            )
        )
    }
}
