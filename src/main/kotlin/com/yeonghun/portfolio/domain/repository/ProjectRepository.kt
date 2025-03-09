package com.yeonghun.portfolio.domain.repository

import com.yeonghun.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

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
interface ProjectRepository: JpaRepository<Project, Long> {
    /*@Query("select distinct p from Project p left join fetch p.skills s left join fetch s.skill where p.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Project>*/

    @Query("select distinct p from Project p left join fetch p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>
}