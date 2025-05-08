package com.kakaogames.mcp.packet

import com.kakaogames.mcp.model.BookItem

data class AladinResponse(
    val version: Int = 0,
    val logo: String = "",
    val title: String = "",
    val link: String = "",
    val pubDate: String = "",
    val totalResults: Int = 0,
    val startIndex: Int = 0,
    val itemsPerPage: Int = 0,
    val query: String = "",
    val searchCategoryId: Int = 0,
    val searchCategoryName: String = "",
    val item: List<BookItem> = emptyList()
)
