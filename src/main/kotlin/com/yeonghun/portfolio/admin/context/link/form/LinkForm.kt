package com.yeonghun.portfolio.admin.context.link.form

import com.yeonghun.portfolio.domain.entity.Link
import jakarta.validation.constraints.NotBlank

/**
 *packageName    : com.yeonghun.portfolio.admin.context.link.form
 * fileName       : LinkForm
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
data class LinkForm(
    @field:NotBlank(message = "필수값입니다.")
    val name: String,

    @field:NotBlank(message = "필수값입니다.")
    val content: String,

    val isActive: Boolean
) {
    fun toLink(): Link {
        return Link(
            name = this.name,
            content = this.content,
            isActive = this.isActive
        )
    }

    fun toLink(id: Long): Link {
        return Link(
            id = id,
            name = this.name,
            content = this.content,
            isActive = this.isActive
        )
    }
}