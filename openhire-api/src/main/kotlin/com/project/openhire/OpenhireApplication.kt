package com.project.openhire

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
@EnableWebSecurity
class OpenhireApplication

fun main(args: Array<String>) {
    runApplication<OpenhireApplication>(*args)
}
