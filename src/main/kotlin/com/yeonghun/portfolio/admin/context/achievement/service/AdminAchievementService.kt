package com.yeonghun.portfolio.admin.context.achievement.service

import com.yeonghun.portfolio.admin.context.achievement.form.AchievementForm
import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.domain.entity.Achievement
import com.yeonghun.portfolio.domain.repository.AchievementRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 *packageName    : com.yeonghun.portfolio.admin.context.achievement.service
 * fileName       : AdminAchievementViewService
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@Service
class AdminAchievementService (
    private val achievementRepository: AchievementRepository
){
    fun getAchievementTable(): TableDTO{
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()
        return TableDTO.of(classInfo, entities)
    }

    @Transactional
    fun save(form: AchievementForm) =
        form.toAchievement().let(achievementRepository::save)

    @Transactional
    fun update(id: Long,form: AchievementForm) =
        form.toAchievement(id).let (achievementRepository::save)
}