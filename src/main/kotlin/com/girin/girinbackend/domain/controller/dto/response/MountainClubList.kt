package com.girin.girinbackend.domain.controller.dto.response

data class MountainClubList(
    val mountainClubList: List<MountainClubElement>,
) {
    data class MountainClubElement(
        val mountainClubId: Long,
        val name: String,
        val zone: String,
    )
}
