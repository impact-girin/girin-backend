package com.girin.girinbackend.domain.entity.club

import com.girin.girinbackend.domain.entity.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_mountain_club")
class MountainClub(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val name: String,

    @Column
    val zone: String,

    @Column
    val age: String,

    @Column
    val introduce: String,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_user_id")
    val headUser: User,
)
