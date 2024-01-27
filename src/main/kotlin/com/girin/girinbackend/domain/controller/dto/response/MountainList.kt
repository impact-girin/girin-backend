package com.girin.girinbackend.domain.controller.dto.response

data class MountainList(
    val mountainList: List<MountainElement>,
) {
    data class MountainElement(
        val mountainId: Long,
        val latitude: Double,
        val longitude: Double,
        val name: String,
        val height: String,
        val detailInfo: String,
        val mountainImageUrl: String,
    )
}
