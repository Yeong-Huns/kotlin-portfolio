package com.yeonghun.portfolio.admin.context.skill.form

import com.yeonghun.portfolio.domain.constant.SkillType
import com.yeonghun.portfolio.domain.entity.Skill
import jakarta.validation.constraints.NotBlank

/**
 *packageName    : com.yeonghun.portfolio.admin.context.skill.form
 * fileName       : SkillForm
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
data class SkillForm (
    @field:NotBlank(message = "필수값입니다.")
    val name: String,
    @field:NotBlank(message = "필수값입니다.")
    val type: String,
    val isActive: Boolean,
){
    fun toSkill(): Skill {
        return Skill(
            name = this.name,
            type = SkillType.valueOf(this.type),
            isActive = this.isActive
        )
    }

    fun toSkill(id:Long): Skill {
        return Skill(
            id = id,
            name = this.name,
            type = SkillType.valueOf(this.type),
            isActive = this.isActive
        )
    }
}