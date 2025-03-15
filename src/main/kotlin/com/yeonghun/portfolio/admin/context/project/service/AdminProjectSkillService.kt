package com.yeonghun.portfolio.admin.context.project.service

import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.domain.repository.ProjectRepository
import com.yeonghun.portfolio.domain.repository.SkillRepository
import com.yeonghun.portfolio.presentation.dto.ProjectDTO
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 *packageName    : com.yeonghun.portfolio.admin.context.project.service
 * fileName       : AdminProjectSkillService
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@Service
class AdminProjectSkillService (
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository
){
    @Transactional
    fun getProjectSkillTable(): TableDTO {
        val projects = projectRepository.findAll()
        val columns = mutableListOf<String>("id", "projectId", "projectName", "skillId", "skillName", "createdDateTime", "updatedDateTime")
        val records = mutableListOf<MutableList<String>>()
        projects.forEach {
            it.skills.forEach {
                val record = mutableListOf<String>()
                record.add(it.id.toString())
                record.add(it.project.id.toString())
                record.add(it.project.name)
                record.add(it.skill.id.toString())
                record.add(it.skill.name)
                record.add(it.createdDateTime.toString())
                record.add(it.updatedDateTime.toString())
                records.add(record)
            }
        }
        return TableDTO(
            name = "ProjectSkill",
            columns = columns,
            records = records
        )
    }
    fun getProjectList(): List<String> =
        projectRepository.findAll().map { "${it.id} (${it.name})"}.toList()


    fun getSkillList(): List<String> =
        skillRepository.findAll().map { "${it.id} (${it.name})"}.toList()

}