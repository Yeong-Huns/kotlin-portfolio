package com.yeonghun.portfolio.presentation.service

import com.yeonghun.portfolio.domain.entity.Introduction
import com.yeonghun.portfolio.domain.entity.Link
import com.yeonghun.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

/**
 *packageName    : com.yeonghun.portfolio.presentation.service
 * fileName       : PresentationServiceTest
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {
    @InjectMocks
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentaionRepository: PresentationRepository

    val DATA_SIZE = 9

    @DisplayName("")
    @Test
    fun testGetIntroductions() {/* given */
        val introductions = mutableListOf<Introduction>()
        (1..DATA_SIZE).forEach {
            introductions.add(Introduction(content = "$it", isActive = it % 2 == 0))
        }

        val activeIntroductions = introductions.filter { it.isActive }

        Mockito.`when`(presentaionRepository.getActiveIntroductions()).thenReturn(activeIntroductions)

        /* when */
        val introductionDTOs = presentationService.getIntroductions()

        /* then */
        assertThat(introductionDTOs).hasSize(DATA_SIZE / 2)
        introductionDTOs.forEach {
            assertThat(it.content.toInt()).isEven()
        }
    }

    @DisplayName("")
    @Test
    fun testGetLinks() {/* given */
        val links = mutableListOf<Link>()
        (1..DATA_SIZE).forEach {
            links.add(Link(name = "$it", content = "$it", isActive = it % 2 != 0))
        }

        val activeLinks = links.filter { it.isActive }

        Mockito.`when`(presentaionRepository.getActiveLinks()).thenReturn(activeLinks)

        /* when */
        val linkDTOs = presentationService.getLinks()

        /* then */
        var expectedSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0) expectedSize += 1
        assertThat(linkDTOs).hasSize(expectedSize)
        linkDTOs.forEach {
            assertThat(it.content.toInt()).isOdd()
        }
    }

}