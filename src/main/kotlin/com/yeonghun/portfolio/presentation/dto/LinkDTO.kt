package com.yeonghun.portfolio.presentation.dto

import com.yeonghun.portfolio.domain.entity.Link

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
data class LinkDTO(
    val name: String,
    val content: String
){
    constructor(link: Link) : this (
        name = link.name.lowercase(),
        content = link.content!!
    )
}
