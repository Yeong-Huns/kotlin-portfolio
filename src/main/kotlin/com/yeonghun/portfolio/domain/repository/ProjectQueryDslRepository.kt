package com.yeonghun.portfolio.domain.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.yeonghun.portfolio.domain.entity.Project
import com.yeonghun.portfolio.domain.entity.QProject.project
import org.springframework.stereotype.Component

/**
 *packageName    : com.yeonghun.portfolio.domain.repository
 * fileName       : ProjectQueryDslRepsitory
 * author         : Yeong-Huns
 * date           : 2025-03-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-10        Yeong-Huns       최초 생성
 */
@Component
class ProjectQueryDslRepository(private val queryFactory: JPAQueryFactory) {
    fun findAllByIsActive(isActive: Boolean): List<Project>{
        return queryFactory.selectDistinct(project)
            .from(project)
            .leftJoin(project.details)
            .leftJoin(project.skills)
            .where(project.isActive.eq(isActive))
            .fetch()
    }
}