package com.yeonghun.portfolio.domain.repository

import com.yeonghun.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 *packageName    : com.yeonghun.portfolio.domain.repository
 * fileName       : HttpInterface
 * author         : Yeong-Huns
 * date           : 2025-03-06
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-06        Yeong-Huns       최초 생성
 */
@Repository
interface IntroductionRepository: JpaRepository<Introduction, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Introduction>
}