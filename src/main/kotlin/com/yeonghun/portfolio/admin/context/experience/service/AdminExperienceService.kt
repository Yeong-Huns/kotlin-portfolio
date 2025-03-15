package com.yeonghun.portfolio.admin.context.experience.service

import com.yeonghun.portfolio.admin.context.experience.form.ExperienceDetailForm
import com.yeonghun.portfolio.admin.context.experience.form.ExperienceForm
import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.admin.exception.AdminBadRequestException
import com.yeonghun.portfolio.domain.entity.Experience
import com.yeonghun.portfolio.domain.entity.ExperienceDetail
import com.yeonghun.portfolio.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.math.exp

/**
 *packageName    : com.yeonghun.portfolio.admin.context.experience.service
 * fileName       : AdminExperienceService
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@Service
class AdminExperienceService(
    private val experienceRepository: ExperienceRepository,
) {
    fun getExperienceTable(): TableDTO {
        val classInfo = Experience::class
        val entities = experienceRepository.findAll()
        return TableDTO.of(classInfo, entities, "details")
    }

    fun getExperienceDetailTable(id: Long?): TableDTO {
        val classInfo = ExperienceDetail::class
        val entities = if(id!=null) experienceRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수가 없습니다. ") }
            .details else emptyList()
        return TableDTO.of(classInfo, entities)
    }

    @Transactional
    fun save(form: ExperienceForm){
        val experienceDetail = form.details
            ?.map (ExperienceDetailForm::toExperienceDetail)
            ?.toMutableList()
        form.toExperience().also{
            it.addDetails(experienceDetail)
            experienceRepository.save(it)
        }
    }

    @Transactional
    fun update(id: Long, form: ExperienceForm){
        val experience = experienceRepository.findById(id)
            .orElseThrow{ throw AdminBadRequestException("Id ${id}에 해당하는 데이터를 찾을 수가 없습니다.") }
        experience.update(
            title = form.title,
            description = form.description,
            startYear = form.startYear,
            startMonth = form.startMonth,
            endYear = form.endYear,
            endMonth = form.endMonth,
            isActive = form.isActive,
        )
        val detailMap = experience.details.associateBy (ExperienceDetail::id)
        form.details?.forEach {
            val entity = detailMap[it.id]
            if(entity != null) {
                entity.update(
                    content = it.content,
                    isActive = it.isActive,
                )
            } else {
                experience.details.add(it.toExperienceDetail())
            }
        }
    }
}