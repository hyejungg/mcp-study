package com.kakaogames.mcp.config

import io.modelcontextprotocol.client.McpSyncClient
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatClientConfig {

    @Bean
    fun chatClient(
        chatClientBuilder: ChatClient.Builder,
        mcpSyncClients: List<McpSyncClient>
    ): ChatClient {
        return chatClientBuilder
            .defaultSystem("""사용 가능한 도구를 적극 활용하여 정확한 답변을 생성하세요. 도구 사용이 필요하면 반드시 호출 후 결과를 반영해야 합니다.""")
            .defaultTools(SyncMcpToolCallbackProvider(mcpSyncClients)) // mcp server 의 도구 바인딩
            .build()
    }
}