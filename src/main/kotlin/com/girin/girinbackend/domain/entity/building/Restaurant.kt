package com.girin.girinbackend.domain.entity.building

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_restaurant")
class Restaurant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val name: String,

    @Column
    val latitude: Double, // 위도

    @Column
    val longitude: Double, // 경도

    @Column
    val restaurantImageUrl: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mountain_id")
    val mountain: Mountain,
)
