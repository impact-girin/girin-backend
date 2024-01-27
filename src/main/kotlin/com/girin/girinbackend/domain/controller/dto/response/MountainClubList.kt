package com.girin.girinbackend.domain.controller.dto.response

data class MountainClubList(
    val mountainClubList: List<MountainClubElement>,
) {
    data class MountainClubElement(
        val mountainClubId: Long,
        val clubName: String,
        val zone: String,
        val maxPeople: Int,
        val introduce: String,
        val mountainClubImageUrl: String,
        val contactLink: String,
    )
}

