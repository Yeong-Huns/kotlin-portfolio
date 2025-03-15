package com.yeonghun.portfolio.admin.context.achievement.service

import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.domain.entity.Achievement
import com.yeonghun.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

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
}