package com.yeonghun.portfolio.presentation.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.json.JSONArray
import org.json.JSONObject
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers

/**
 *packageName    : com.yeonghun.portfolio.presentation.controller
 * fileName       : PresentationApiControllerTest
 * author         : Yeong-Huns
 * date           : 2025-03-13
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-13        Yeong-Huns       최초 생성
 */
val logger = KotlinLogging.logger {}
@AutoConfigureMockMvc
@SpringBootTest
@DisplayName("[API 컨트롤러 테스트]")
class PresentationApiControllerTest (
    @Autowired private val mockMvc: MockMvc,
){
    @DisplayName("Introductions 조회")
    @Test
    fun testGetIntroductions() {
        /* given */
        val uri = "/api/v1/introductions"

        /* when */
        val mvcResult = performGet(uri)
        val contentAsString = mvcResult.response.contentAsString
        val jsonArray = JSONArray(contentAsString)

        /* then */
        assertThat(jsonArray.length()).isPositive()
    }

    @DisplayName("Links 조회")
    @Test
    fun testGetLinks() {
        /* given */
        val uri = "/api/v1/links"

        /* when */
        val mvcResult = performGet(uri)
        val contentAsString = mvcResult.response.contentAsString
        val jsonArray = JSONArray(contentAsString)

        /* then */
        assertThat(jsonArray.length()).isPositive()
    }

    @DisplayName("Resume 조회")
    @Test
    fun testGetResume() {
        /* given */
        val uri = "/api/v1/resume"

        /* when */
        val mvcResult = performGet(uri)
        val contentAsString = mvcResult.response.contentAsString
        val jsonObject = JSONObject(contentAsString)

        /* then */
        logger.info{jsonObject.optJSONObject("experiences")}
        assertThat(jsonObject.optJSONArray("experiences").length()).isPositive()
        assertThat(jsonObject.optJSONArray("achievements").length()).isPositive()
        assertThat(jsonObject.optJSONArray("skills").length()).isPositive()
    }


    private fun performGet(uri: String): MvcResult {
        return mockMvc
            .perform (MockMvcRequestBuilders.get(uri))
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
    }

}