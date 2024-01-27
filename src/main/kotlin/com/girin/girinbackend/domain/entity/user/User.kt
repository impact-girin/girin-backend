package com.girin.girinbackend.domain.entity.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val phoneNumber: String,

    @Column
    val password: String,

    @Column
    val age: String,

    @Column
    val zone: String,

    @Column
    val name: String,

    rewardPoint: Long,
) {
    @Column
    var rewardPoint = rewardPoint
        protected set

    fun plusRewardPoint(rewardPoint: Long) {
        this.rewardPoint += rewardPoint
    }

    fun minusRewardPoint(rewardPoint: Long) {
        this.rewardPoint -= rewardPoint
    }
}
