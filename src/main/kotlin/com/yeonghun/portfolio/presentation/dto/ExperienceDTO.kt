package com.yeonghun.portfolio.presentation.dto

/**
 *packageName    : com.yeonghun.portfolio.presentation.dto
 * fileName       : AchievementDTO
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
data class ExperienceDTO(
    val title: String,
    val description: String,
    val startYearMonth: String,
    val endYearMonth: String?,
    val details: List<String>
)
