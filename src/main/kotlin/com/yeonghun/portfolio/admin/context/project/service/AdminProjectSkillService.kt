package com.yeonghun.portfolio.admin.context.project.service

import com.yeonghun.portfolio.admin.context.project.form.ProjectSkillForm
import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.admin.exception.AdminBadRequestException
import com.yeonghun.portfolio.admin.exception.AdminInternalServerException
import com.yeonghun.portfolio.domain.entity.ProjectSkill
import com.yeonghun.portfolio.domain.repository.ProjectRepository
import com.yeonghun.portfolio.domain.repository.ProjectSkillRepository
import com.yeonghun.portfolio.domain.repository.SkillRepository
import com.yeonghun.portfolio.utils.findByIdOrThrow
import org.springframework.data.jpa.domain.AbstractPersistable_.id

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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
    private val skillRepository: SkillRepository,
    private val projectSkillRepository: ProjectSkillRepository
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

    @Transactional
    fun save(form: ProjectSkillForm){
        val projectId = parseId(form.project)
        val skillId = parseId(form.skill)
        projectSkillRepository.findByProjectIdAndSkillId(projectId, skillId)?.let{ throw AdminBadRequestException("이미 매핑된 데이터입니다.") }

        val project = projectRepository.findByIdOrThrow(projectId)
        val skill = skillRepository.findByIdOrThrow(skillId)

        ProjectSkill(
            project = project,
            skill = skill
        ).also{ project.skills.add(it) }
    }

    private fun parseId(line: String): Long{
        try{
            val endIndex = line.indexOf(" ")
            return line.slice(0 until endIndex).toLong()
        }catch (e: Exception){
            throw AdminInternalServerException("ID 추출 중 오류가 발생했습니다.")
        }
    }

    @Transactional
    fun delete(id: Long) = projectSkillRepository.deleteById(id)

}