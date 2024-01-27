package com.girin.girinbackend.domain.service

import com.girin.girinbackend.domain.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RewardService(
    private val userFacade: UserFacade,
) {

    @Transactional
    fun controlRewardPoint(operator: String, targetPoint: Long): String {
        val user = userFacade.getCurrentUser()
        when (operator) {
            "plus" -> user.plusRewardPoint(targetPoint)
            "minus" -> user.minusRewardPoint(targetPoint)
        }

        return user.rewardPoint.toString()
    }
}
