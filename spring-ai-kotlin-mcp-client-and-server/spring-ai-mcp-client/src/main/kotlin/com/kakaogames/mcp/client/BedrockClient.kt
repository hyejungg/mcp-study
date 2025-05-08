package com.kakaogames.mcp.client

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.model.tool.ToolCallingChatOptions
import org.springframework.stereotype.Component

@Component
class BedrockClient(private val chatClient: ChatClient) {
    val modelId = "us.amazon.nova-pro-v1:0"

    fun getModelOptions(): ToolCallingChatOptions {
        return ToolCallingChatOptions.builder()
            .model(modelId)
            .temperature(0.6)
            .maxTokens(1280)
            .build();
    }

    fun chatWithTool(query: String): String? {
        return chatClient.prompt(query)
            .options(getModelOptions())
            .call()
            .content();
    }
}