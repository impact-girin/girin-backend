package com.girin.girinbackend.domain.repository

import com.girin.girinbackend.domain.entity.guestbook.GuestBook
import org.springframework.data.repository.CrudRepository

interface GuestBookRepository : CrudRepository<GuestBook, Long> {
    fun findAllByMountainName(name: String): List<GuestBook>
}
