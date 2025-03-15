package com.yeonghun.portfolio.admin.context.introduction.service

import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.domain.entity.Introduction
import com.yeonghun.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

/**
 *packageName    : com.yeonghun.portfolio.admin.context.introduction.service
 * fileName       : AdminIntroductionViewService
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@Service
class AdminIntroductionService (
    private val introductionRepository: IntroductionRepository
){

    fun getIntroductionTable(): TableDTO{
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()
        return TableDTO.of(classInfo, entities)
    }
}