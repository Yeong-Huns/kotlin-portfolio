package com.yeonghun.portfolio.domain.repository

import com.yeonghun.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *packageName    : com.yeonghun.portfolio.domain.repository
 * fileName       : AchievementRepository
 * author         : Yeong-Huns
 * date           : 2025-03-06
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-06        Yeong-Huns       최초 생성
 */
@Repository
interface ExperienceRepository: JpaRepository<Experience, Long> {
    fun findAllByActive(isActive: Boolean): List<Experience>
}