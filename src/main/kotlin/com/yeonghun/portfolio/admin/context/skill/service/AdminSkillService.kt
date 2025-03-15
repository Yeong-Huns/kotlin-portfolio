package com.yeonghun.portfolio.admin.context.skill.service

import com.yeonghun.portfolio.admin.context.skill.form.SkillForm
import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.domain.entity.Skill
import com.yeonghun.portfolio.domain.repository.SkillRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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
class AdminSkillService (
    private val skillRepository: SkillRepository
){
    fun getSkillTable(): TableDTO{
        val classInfo = Skill::class
        val entities = skillRepository.findAll()
        return TableDTO.of(classInfo, entities)
    }
    @Transactional
    fun save(form: SkillForm) = form.toSkill().let (skillRepository::save)

    @Transactional
    fun update(id: Long, form: SkillForm) = form.toSkill(id).let (skillRepository::save)
}