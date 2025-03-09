package com.yeonghun.portfolio.domain.repository

import com.yeonghun.portfolio.domain.entity.Link
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
interface LinkRepository: JpaRepository<Link, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Link>
}