package com.kakaogames.mcp.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kakaogames.mcp.config.AladinProperties
import com.kakaogames.mcp.packet.AladinResponse
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class AladinClient(
    private val restClient: RestClient,
    private val aladinProps: AladinProperties,// baseUrl, TTBKey 등 주입
    private val jacksonObjectMapper: ObjectMapper
) {
    fun searchBooksByTitle(
        query: String,
        queryType: String = "Keyword",
        maxResults: Int = 10,
        start: Int = 1,
        searchTarget: String = "Book",
        output: String = "js", // json
        version: String = "20131101"
    ): AladinResponse {
        val uri = "/ItemSearch.aspx?TTBKey=${aladinProps.ttbKey}" +
                "&Query=$query&QueryType=$queryType&MaxResults=$maxResults&start=$start" +
                "&SearchTarget=$searchTarget&output=$output&Version=$version"

        val response = restClient.get()
            .uri("${aladinProps.baseUrl}$uri")
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError) { _, response ->
                throw RuntimeException("요청 오류: ${response.statusCode} | ${response.body.toString()}")
            }
            .onStatus(HttpStatusCode::is5xxServerError) { _, response ->
                throw RuntimeException("서버 오류: ${response.statusCode} | ${response.body.toString()}")
            }
            .toEntity(String::class.java)

        println("📦 응답 코드): ${response.statusCode}")
        println("📦 응답 본문(raw): ${response.body}")
        println("📦 응답 헤더: ${response.headers.contentType}")

        println("${jacksonObjectMapper().readValue(response.body, AladinResponse::class.java)}")

        return if (response.statusCode === HttpStatus.OK) {
            jacksonObjectMapper().readValue(response.body, AladinResponse::class.java)

        } else {
            AladinResponse()
        }
    }

    fun getBookDetail(
        itemId: String,
        itemIdType: String = "ISBN13",
        output: String = "json",  // json
        version: String = "20131101"
    ): AladinResponse {
        val uri = "/ItemLookUp.aspx?TTBKey=${aladinProps.ttbKey}" +
                "&ItemId=$itemId&ItemIdType=$itemIdType&output=$output&Version=$version"

        val response = restClient.get()
            .uri("${aladinProps.baseUrl}$uri")
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError) { _, response ->
                throw RuntimeException("요청 오류: ${response.statusCode} | ${response.body.toString()}")
            }
            .onStatus(HttpStatusCode::is5xxServerError) { _, response ->
                throw RuntimeException("서버 오류: ${response.statusCode} | ${response.body.toString()}")
            }
            .toEntity(String::class.java)

        println("📦 응답 코드): ${response.statusCode}")
        println("📦 응답 본문(raw): ${response.body}")
        println("📦 응답 헤더: ${response.headers.contentType}")

        println("${jacksonObjectMapper().readValue(response.body, AladinResponse::class.java)}")

        return if (response.statusCode === HttpStatus.OK) {
            jacksonObjectMapper().readValue(response.body, AladinResponse::class.java)
        } else {
            AladinResponse()
        }
    }
}
