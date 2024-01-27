package com.girin.girinbackend.domain.controller

import com.girin.girinbackend.domain.service.RewardService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/reward")
@RestController
class RewardController(
    private val rewardService: RewardService,
) {

    @PutMapping("/control")
    fun controlRewardPoint(
        @RequestParam("operator") operator: String,
        @RequestParam("point") targetPoint: Long,
    ) {
        rewardService.controlRewardPoint(operator, targetPoint)
    }
}
