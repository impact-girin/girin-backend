package com.girin.girinbackend.domain.entity.building

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_mountain")
class Mountain(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val latitude: Double, // 위도

    @Column
    val longitude: Double, // 경도

    @Column
    val name: String,

    @Column
    val height: String,

    @Column
    val detailInfo: String,

    @Column
    val mountainImageUrl: String,
)
