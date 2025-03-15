package com.yeonghun.portfolio.admin.context.project.service

import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.admin.exception.AdminBadRequestException
import com.yeonghun.portfolio.domain.entity.Project
import com.yeonghun.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service

/**
 *packageName    : com.yeonghun.portfolio.admin.context.project.service
 * fileName       : AdminProjectService
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@Service
class AdminProjectService (
    private val projectRepository: ProjectRepository,
){
    fun getProjectTable():TableDTO {
        val classInfo = Project::class
        val entities = projectRepository.findAll()
        return TableDTO.of(classInfo, entities, "details", "skills")
    }

    fun getProjectDetailTable(id: Long?): TableDTO {
        val classInfo = Project::class
        val entities = if(id!=null) projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수가 없습니다. ") }
            .details else emptyList()
        return TableDTO.of(classInfo, entities)
    }
}