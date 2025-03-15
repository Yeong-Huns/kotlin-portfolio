package com.yeonghun.portfolio.admin.context.experience.form

import com.yeonghun.portfolio.domain.entity.ExperienceDetail
import jakarta.validation.constraints.NotBlank

/**
 *packageName    : com.yeonghun.portfolio.admin.context.experience.form
 * fileName       : ExperienceDetailForm
 * author         : Yeong-Huns
 * date           : 2025-03-16
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-16        Yeong-Huns       최초 생성
 */
data class ExperienceDetailForm (
    val id: Long,

    @field:NotBlank(message = "필수값입니다.")
    val content: String,

    val isActive: Boolean,
){
    fun toExperienceDetail() : ExperienceDetail =
        ExperienceDetail(
            content = this.content,
            isActive = this.isActive,
        )
}