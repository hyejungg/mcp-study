package com.kakaogames.mcp.controller

import com.kakaogames.mcp.client.BedrockClient
import com.kakaogames.mcp.model.QueryRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class QueryController(private val bedrockClient: BedrockClient) {

    @GetMapping("test")
    fun test(): ResponseEntity<String> {
        println("Received response: test success!!")
        return ResponseEntity.ok("test success!!")
    }

    @PostMapping("/query")
    fun handleQuery(@RequestBody request: QueryRequest): ResponseEntity<String> {
        val query = request.query
        val response = bedrockClient.chatWithTool(query)
        println("Received response: $response")
        return ResponseEntity.ok(response)
    }
}