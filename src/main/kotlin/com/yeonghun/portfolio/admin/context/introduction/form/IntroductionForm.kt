package com.yeonghun.portfolio.admin.context.introduction.form

import com.yeonghun.portfolio.domain.entity.Introduction
import jakarta.validation.constraints.NotBlank

/**
 *packageName    : com.yeonghun.portfolio.admin.context.introduction.form
 * fileName       : IntroductionForm
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
data class IntroductionForm(
    @field:NotBlank(message = "필수값입니다.")
    val content: String,
    val isActive: Boolean
) {
    fun toIntroduction(): Introduction {
        return Introduction(
            content = this.content,
            isActive = this.isActive
        )
    }

    fun toIntroduction(id:Long): Introduction {
        return Introduction(
            id = id,
            content = this.content,
            isActive = this.isActive
        )
    }
}