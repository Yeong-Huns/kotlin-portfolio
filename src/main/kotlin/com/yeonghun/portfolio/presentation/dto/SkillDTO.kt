package com.yeonghun.portfolio.presentation.dto

import com.yeonghun.portfolio.domain.entity.Skill

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
data class SkillDTO(
    val name: String,
    val type: String,
){
    constructor(skill: Skill) : this(
        name = skill.name,
        type = skill.type.toString(),
    )
}
