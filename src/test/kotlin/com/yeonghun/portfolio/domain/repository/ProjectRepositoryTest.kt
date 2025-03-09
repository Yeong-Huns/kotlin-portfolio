package com.yeonghun.portfolio.domain.repository

import com.yeonghun.portfolio.domain.constant.SkillType
import com.yeonghun.portfolio.domain.entity.Project
import com.yeonghun.portfolio.domain.entity.ProjectDetail
import com.yeonghun.portfolio.domain.entity.ProjectSkill
import com.yeonghun.portfolio.domain.entity.Skill
import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

/**
 *packageName    : com.yeonghun.portfolio.domain.repository
 * fileName       : ProjectRepositoryTest
 * author         : Yeong-Huns
 * date           : 2025-03-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-10        Yeong-Huns       최초 생성
 */

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProjectRepositoryTest (
    @Autowired val projectRepository: ProjectRepository,
    @Autowired val skillRepository: SkillRepository
){
    val DATA_SIZE = 10
    private fun createProject(n: Int): Project {
        val project = Project(
            name = "$n",
            description = "테스트 설명 $n",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 9,
            isActive = true,
        )
        val details = mutableListOf<ProjectDetail>()
        (1..n).forEach {
            val projectDetail = ProjectDetail(content = "테스트 $it", isActive = true, url = null)
            details.add(projectDetail)
        }
        project.addDetails(details)

        val skills = skillRepository.findAll()
        val skillsUsedInProject = skills.subList(0, n)
        skillsUsedInProject.forEach {
            val projectSkill = ProjectSkill(project = project, skill = it)
            project.skills.add(projectSkill)
        }
        return project
    }

    @BeforeAll
    fun beforeAll() {
        logger.info{"---스킬 데이터 초기화 시작---"}
        val skills = mutableListOf<Skill>()
        (1..DATA_SIZE).forEach {
            val skillTypes = SkillType.entries.toTypedArray()
            val test = skillTypes[0]
            val skill = Skill(name = "테스트 $it", type = skillTypes[it%skillTypes.count()], isActive = true)
            skills.add(skill)
        }
        skillRepository.saveAll(skills)

        val projects = mutableListOf<Project>()
        (1..DATA_SIZE).forEach {
            val project = createProject(it)
            projects.add(project)
        }
        projectRepository.saveAll(projects)
    }

    @DisplayName("사전 지정한 데이터 조회에 성공한다.")
    @Test
    fun testFindAll() {
        val projects = projectRepository.findAll()
        assertThat(projects).hasSize(DATA_SIZE)

        projects.forEach {
            assertThat(it.details).hasSize(it.name.toInt())
        }
    }


    @DisplayName("IsActive 가 true 인 데이터 조회에 성공한다.")
    @Test
    fun testFindAllByIsActive() {
        val projects = projectRepository.findAllByIsActive(true)
        assertThat(projects).hasSize(DATA_SIZE)

        projects.forEach {
            assertThat(it.details).hasSize(it.name.toInt())
        }
    }

}