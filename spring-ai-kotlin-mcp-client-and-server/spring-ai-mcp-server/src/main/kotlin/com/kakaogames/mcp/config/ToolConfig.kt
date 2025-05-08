package com.kakaogames.mcp.config

import com.kakaogames.mcp.tool.AladinSearch
import org.springframework.ai.tool.ToolCallbackProvider
import org.springframework.ai.tool.method.MethodToolCallbackProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ToolConfig(private val aladinSearch: AladinSearch) {

    /**
     * 도구 등록
     */
    @Bean
    fun toolCallbackProvider(): ToolCallbackProvider {
        return MethodToolCallbackProvider.builder()
            .toolObjects(aladinSearch)
            .build()
    }
}
