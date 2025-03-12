package com.yeonghun.portfolio.presentation.dto

import com.yeonghun.portfolio.domain.entity.Project
import com.yeonghun.portfolio.domain.entity.ProjectSkill
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
data class ProjectDTO(
    val name: String,
    val description: String,
    val startYearMonth: String,
    val endYearMonth: String?,
    val details: List<ProjectDetailDTO>,
    val skills: List<SkillDTO>
){
    constructor(project: Project) : this(
        name = project.name,
        description = project.description,
        startYearMonth = "${project.startYear}.${project.startMonth}",
        endYearMonth = project.getEndYearMonth(),
        details = project.details.filter { it.isActive }.map(::ProjectDetailDTO),
        skills = project.skills.map{it.skill}.filter { it.isActive }.map(::SkillDTO)
    )

}
