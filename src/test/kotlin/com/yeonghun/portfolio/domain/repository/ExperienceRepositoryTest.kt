package com.yeonghun.portfolio.domain.repository

import com.yeonghun.portfolio.domain.entity.Experience
import com.yeonghun.portfolio.domain.entity.ExperienceDetail
import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles

/**
 *packageName    : com.yeonghun.portfolio.domain.repository
 * fileName       : ExperienceRepositoryTest
 * author         : Yeong-Huns
 * date           : 2025-03-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-10        Yeong-Huns       최초 생성
 */
val logger = KotlinLogging.logger {}

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest (
    @Autowired val experienceRepository: ExperienceRepository,
){
    val DATA_SIZE = 10 ;

    private fun createExperience(n: Int): Experience {
        val experience = Experience(
            title = "$n",
            description = "테스트 설명 $n",
            startYear = 2023,
            startMonth = 9,
            endYear = 2023,
            endMonth = 9,
            isActive = true,
        )
        val details = mutableListOf<ExperienceDetail>()
        (1..n).forEach{
            val experienceDetail = ExperienceDetail(content = "테스트 $it", isActive = true)
            details.add(experienceDetail)
        }
        experience.addDetails(details)
        return experience
    }

    @BeforeAll
    fun beforeAll() {
        logger.info { "---테이터 초기화 이전 조회 시작---" }
        val beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0)
        logger.info { "---테이터 초기화 이전 조회 종료---" }
        logger.info { "---테이터 초기화 시작---" }
        val experiences = mutableListOf<Experience>()
        (1..DATA_SIZE).forEach{
            val experience = createExperience(it)
            experiences.add(experience)
        }
        experienceRepository.saveAll(experiences)
        logger.info { "---테이터 초기화 종료---" }
    }

    @DisplayName("사전 지정한 데이터 조회에 성공한다.")
    @Test
    fun testFindAll() {
        val experiences = experienceRepository.findAll()
        assertThat(experiences).hasSize(DATA_SIZE)

        experiences.forEach {
            assertThat(it.details).hasSize(it.title.toInt())
            logger.info{"details size : ${it.details.count()}"}
        }
    }


    @DisplayName("IsActive 가 true 인 데이터 조회에 성공한다.")
    @Test
    fun testFindAllByIsActive() {
        val experiences = experienceRepository.findAllByIsActive(true)
        assertThat(experiences).hasSize(DATA_SIZE)

        experiences.forEach {
            assertThat(it.details).hasSize(it.title.toInt())
            logger.info{"details size : ${it.details.count()}"}
        }
    }


}