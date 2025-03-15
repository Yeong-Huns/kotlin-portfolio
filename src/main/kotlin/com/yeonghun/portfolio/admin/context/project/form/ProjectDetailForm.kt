package com.yeonghun.portfolio.admin.context.project.form

import com.yeonghun.portfolio.domain.entity.ProjectDetail
import jakarta.validation.constraints.NotBlank

/**
 *packageName    : com.yeonghun.portfolio.admin.context.project.form
 * fileName       : ProjectDetailForm
 * author         : Yeong-Huns
 * date           : 2025-03-16
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-16        Yeong-Huns       최초 생성
 */
class ProjectDetailForm(
    val id: Long,

    @field:NotBlank(message = "필수값입니다.")
    val content: String,

    val url: String?,

    val isActive: Boolean,
) {
    fun toProjectDetail(): ProjectDetail =
        ProjectDetail(
            content = this.content,
            isActive = this.isActive,
            url = this.url,
        )
}