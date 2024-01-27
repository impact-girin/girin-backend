package com.girin.girinbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class GirinBackendApplication

fun main(args: Array<String>) {
    runApplication<GirinBackendApplication>(*args)
}
