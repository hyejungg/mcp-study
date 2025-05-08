package com.kakaogames.mcp

import com.kakaogames.mcp.config.AladinProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(AladinProperties::class)
@SpringBootApplication
class McpServerApplication

fun main(args: Array<String>) {
    runApplication<McpServerApplication>(*args)
}
