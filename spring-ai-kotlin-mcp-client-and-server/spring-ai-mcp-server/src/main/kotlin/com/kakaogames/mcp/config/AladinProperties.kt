package com.kakaogames.mcp.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "aladin.api")
data class AladinProperties(
    val baseUrl: String,
    val ttbKey: String
)
