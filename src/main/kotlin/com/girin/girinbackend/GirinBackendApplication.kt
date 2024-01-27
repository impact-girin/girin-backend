package com.girin.girinbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

internal const val BASE_PACKAGE = "com.girin.girinbackend"

@ConfigurationPropertiesScan
@SpringBootApplication
class GirinBackendApplication

fun main(args: Array<String>) {
    runApplication<GirinBackendApplication>(*args)
}
