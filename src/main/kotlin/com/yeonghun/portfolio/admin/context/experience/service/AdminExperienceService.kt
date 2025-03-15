package com.yeonghun.portfolio.admin.context.experience.service

import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.admin.exception.AdminBadRequestException
import com.yeonghun.portfolio.domain.entity.Experience
import com.yeonghun.portfolio.domain.entity.ExperienceDetail
import com.yeonghun.portfolio.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service

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
}