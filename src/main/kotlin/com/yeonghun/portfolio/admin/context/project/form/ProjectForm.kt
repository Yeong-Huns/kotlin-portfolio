package com.yeonghun.portfolio.admin.context.project.form

import com.yeonghun.portfolio.domain.entity.Project
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

/**
 *packageName    : com.yeonghun.portfolio.admin.context.project.form
 * fileName       : ProjectForm
 * author         : Yeong-Huns
 * date           : 2025-03-16
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-16        Yeong-Huns       최초 생성
 */
data class ProjectForm (
    @field:NotBlank(message = "필수값입니다.")
    val name: String,

    @field:NotBlank(message = "필수값입니다.")
    val description: String,

    @field:Positive(message = "0보다 커야합니다.")
    val startYear: Int,

    @field:Min(value = 1, message = "최솟값은 1입니다.")
    @field:Max(value = 12, message = "최댓값은 12입니다.")
    val startMonth: Int,

    val endYear: Int?,
    val endMonth: Int?,
    val isActive: Boolean,
    val details: List<ProjectDetailForm>?
){
    fun toProject(): Project =
        Project(
            name = this.name,
            description = this.description,
            startYear = this.startYear,
            startMonth = this.startMonth,
            endYear = this.endYear,
            endMonth = this.endMonth,
            isActive = this.isActive,
        )
}