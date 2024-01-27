package com.girin.girinbackend.infra.feign.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "MountainClient", url = "https://apis.data.go.kr/1400000/service/cultureInfoService2")
interface MountainClient {

    @GetMapping("/mntInfoOpenAPI2")
    fun getMountainInfo(
        @RequestParam("searchWrd") keyword: String,
        @RequestParam("pageNo") pageNumber: Int?,
        @RequestParam("numOfRows") limit: Int?,
        @RequestParam("ServiceKey") serviceKey: String,
    ): String
}
