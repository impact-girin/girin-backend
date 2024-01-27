package com.girin.girinbackend.domain.controller.dto.response

import com.girin.girinbackend.domain.controller.dto.response.MountainClubList.MountainClubElement

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

data class OneMountainClubElement(
    val mountainClubId: Long,
    val clubName: String,
    val zone: String,
    val currentPeople: Int, // 현재 인원수
    val introduce: String, // 소개
    val mountainClubImageUrl: String, // 이미지
    val contactLink: String,
    val mountainInfo: MountainInfo,
) {
    data class MountainInfo(
        val height: String,
        val detailInfo: String,
    )
}

data class MyMountainClubList(
    val myMountainClubList: List<MountainClubElement>,
)
