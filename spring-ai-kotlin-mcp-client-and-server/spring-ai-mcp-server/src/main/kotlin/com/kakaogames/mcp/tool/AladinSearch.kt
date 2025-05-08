package com.kakaogames.mcp.tool

import com.kakaogames.mcp.client.AladinClient
import com.kakaogames.mcp.packet.AladinResponse
import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.stereotype.Component

@Component
class AladinSearch(private val aladinClient: AladinClient) {
    @Tool(
        name = "search_books",
        description = "Search for books by title, author, or keyword"
    )
    fun searchByTitle(
        @ToolParam(description = "검색어") title: String,
        @ToolParam(description = "페이징") start: Int,
        @ToolParam(description = "최대 결과 수") maxResults: Int
    ): AladinResponse {
        println("searchByTitle : $title : start : $start : maxResults : $maxResults")
        val response = aladinClient.searchBooksByTitle(query = title, start = start, maxResults = maxResults)
        println("get result size : ${response.item.size}")
        return response
    }

    @Tool(
        name = "book_search_by_isbn",
        description = "Look up book information by ISBN."
    )
    fun getBookByIsbn(
        @ToolParam(description = "isbn") isbn: String
    ): AladinResponse {
        println("getBookByIsbn : $isbn")
        val response = aladinClient.getBookDetail(isbn)
        println("response : $response")
        return response
    }
}