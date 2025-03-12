package com.yeonghun.portfolio.presentation.service

import com.yeonghun.portfolio.presentation.dto.IntroductionDTO
import com.yeonghun.portfolio.presentation.dto.LinkDTO
import com.yeonghun.portfolio.presentation.dto.ProjectDTO
import com.yeonghun.portfolio.presentation.dto.ResumeDTO
import com.yeonghun.portfolio.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 *packageName    : com.yeonghun.portfolio.presentation.service
 * fileName       : PresentationService
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
@Service
class PresentationService (
    private val presentationRepository: PresentationRepository
){
    @Transactional(readOnly = true)
    fun getIntroductions():List<IntroductionDTO> {
        val introduction = presentationRepository.getActiveIntroductions()
        return introduction.map(::IntroductionDTO)
    }

    @Transactional(readOnly = true)
    fun getLinks():List<LinkDTO>{
        val links = presentationRepository.getActiveLinks()
        return links.map(::LinkDTO)
    }

    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()

        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills
        )
    }

    @Transactional(readOnly = true)
    fun getProjects():List<ProjectDTO>{
        val projects = presentationRepository.getActiveProjects()
        return projects.map(::ProjectDTO)
    }
}