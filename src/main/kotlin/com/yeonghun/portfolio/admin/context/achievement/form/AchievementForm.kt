package com.yeonghun.portfolio.admin.context.achievement.form

import com.yeonghun.portfolio.domain.entity.Achievement
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

/**
 *packageName    : com.yeonghun.portfolio.admin.context.achievement.form
 * fileName       : AchievementForm
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
data class AchievementForm (
    @field:NotBlank(message = "필수값입니다.")
    val title: String,
    val description: String,
    val host: String,
    val achievedDate: String,
    val isActive: Boolean
){
    fun toAchievement(): Achievement {
        return Achievement(
            title = this.title,
            description = this.description,
            achievedDate = LocalDate.parse(this.achievedDate),
            host = this.host,
            isActive = this.isActive
        )
    }
    fun toAchievement(id: Long): Achievement {
        return Achievement(
            id = id,
            title = this.title,
            description = this.description,
            achievedDate = LocalDate.parse(this.achievedDate),
            host = this.host,
            isActive = this.isActive
        )
    }
}