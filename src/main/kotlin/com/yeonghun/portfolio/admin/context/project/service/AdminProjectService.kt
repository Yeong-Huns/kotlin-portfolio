package com.yeonghun.portfolio.admin.context.project.service

import com.yeonghun.portfolio.admin.context.project.form.ProjectDetailForm
import com.yeonghun.portfolio.admin.context.project.form.ProjectForm
import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.admin.exception.AdminBadRequestException
import com.yeonghun.portfolio.domain.entity.Project
import com.yeonghun.portfolio.domain.entity.ProjectDetail
import com.yeonghun.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    @Transactional
    fun save(form: ProjectForm){
        val projectDetail = form.details
            ?.map (ProjectDetailForm::toProjectDetail)
            ?.toMutableList()
        form.toProject().also{
            it.addDetails(projectDetail)
            projectRepository.save(it)
        }
    }

    @Transactional
    fun update(id: Long, form: ProjectForm){
        val project = projectRepository.findById(id)
            .orElseThrow{ throw AdminBadRequestException("Id ${id}에 해당하는 데이터를 찾을 수가 없습니다.") }
        project.update(
            name = form.name,
            description = form.description,
            startYear = form.startYear,
            startMonth = form.startMonth,
            endYear = form.endYear,
            endMonth = form.endMonth,
            isActive = form.isActive,
        )
        val detailMap = project.details.associateBy(ProjectDetail::id)
        form.details?.forEach {
            val entity = detailMap[it.id]
            if(entity != null) {
                entity.update(
                    content = it.content,
                    url = it.url,
                    isActive = it.isActive,
                )
            } else {
                project.details.add(it.toProjectDetail())
            }
        }
    }
}