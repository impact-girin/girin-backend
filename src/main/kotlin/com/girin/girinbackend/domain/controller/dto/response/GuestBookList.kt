package com.girin.girinbackend.domain.controller.dto.response

data class GuestBookList(
    val guestBookList: List<GuestBookElement>,
) {
    data class GuestBookElement(
        val userName: String,
        val mountainName: String,
        val mountainImageUrl: String,
    )
}
