package com.yeonghun.portfolio.admin.context.introduction.service

import com.yeonghun.portfolio.admin.context.introduction.form.IntroductionForm
import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.domain.entity.Introduction
import com.yeonghun.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

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

    @Transactional
    fun save(form: IntroductionForm) =
        form.toIntroduction().let(introductionRepository::save)

    @Transactional
    fun update(id: Long, form: IntroductionForm) =
        form.toIntroduction(id).let(introductionRepository::save)

}