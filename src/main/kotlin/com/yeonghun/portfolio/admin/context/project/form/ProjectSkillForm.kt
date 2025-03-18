package com.yeonghun.portfolio.admin.context.project.form

import jakarta.validation.constraints.NotBlank

/**
 *packageName    : com.yeonghun.portfolio.admin.context.project.form
 * fileName       : ProjectSkillForm
 * author         : Yeong-Huns
 * date           : 2025-03-18
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        Yeong-Huns       최초 생성
 */
data class ProjectSkillForm (
    @field:NotBlank(message = "필수값입니다.")
    val project: String,
    @field:NotBlank(message = "필수값입니다.")
    val skill: String
){
}