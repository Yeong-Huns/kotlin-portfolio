package com.yeonghun.portfolio.presentation.dto

import com.yeonghun.portfolio.domain.entity.ProjectDetail

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
data class ProjectDetailDTO(
    val content: String,
    val url: String?,
){
    constructor(projectDetail: ProjectDetail) : this(
        content = projectDetail.content,
        url = projectDetail.url
    )
}
