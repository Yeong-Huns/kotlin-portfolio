package com.yeonghun.portfolio.presentation.repository

import com.yeonghun.portfolio.domain.entity.Achievement
import com.yeonghun.portfolio.domain.entity.Experience
import com.yeonghun.portfolio.domain.entity.Introduction
import com.yeonghun.portfolio.domain.entity.Link
import com.yeonghun.portfolio.domain.entity.Project
import com.yeonghun.portfolio.domain.entity.Skill
import com.yeonghun.portfolio.domain.repository.AchievementRepository
import com.yeonghun.portfolio.domain.repository.ExperienceRepository
import com.yeonghun.portfolio.domain.repository.IntroductionRepository
import com.yeonghun.portfolio.domain.repository.LinkRepository
import com.yeonghun.portfolio.domain.repository.ProjectQueryDslRepository
import com.yeonghun.portfolio.domain.repository.ProjectRepository
import com.yeonghun.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Repository

/**
 *packageName    : com.yeonghun.portfolio.presentation.repository
 * fileName       : PresentationRepository
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
@Repository
class PresentationRepository (
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectQueryDslRepository: ProjectQueryDslRepository,
    private val experienceRepository: ExperienceRepository,
){
    fun getActiveAchievements(): List<Achievement> =
        achievementRepository.findAllByIsActive(true)

    fun getActiveExperiences(): List<Experience> =
        experienceRepository.findAllByIsActive(true)

    fun getActiveIntroductions(): List<Introduction> =
        introductionRepository.findAllByIsActive(true)

    fun getActiveLinks(): List<Link> =
        linkRepository.findAllByIsActive(true)

    fun getActiveProjects(): List<Project> =
        projectQueryDslRepository.findAllByIsActive(true)

    fun getActiveSkills(): List<Skill> =
        skillRepository.findAllByIsActive(true)
}