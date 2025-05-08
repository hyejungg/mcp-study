package com.kakaogames.mcp.model

data class BookItem(
    val title: String,
    val link: String,
    val author: String,
    val pubDate: String,
    val description: String,
    val isbn: String,
    val isbn13: String,
    val itemId: Long,
    var priceSales: Int, // 판매가
    val priceStandard: Int, // 정가
    val mallType: String,
    val stockStatus: String,
    val mileage: Int,
    val cover: String,
    val categoryId: Long,
    val categoryName: String,
    val publisher: String,
    val salesPoint: Int,
    val adult: Boolean,
    val fixedPrice: Boolean,
    val customerReviewRank: Int,
    val seriesInfo: SeriesInfo?,
    val subInfo: Map<String, Any>?
)