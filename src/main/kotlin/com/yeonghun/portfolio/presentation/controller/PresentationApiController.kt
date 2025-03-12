package com.yeonghun.portfolio.presentation.controller

import com.yeonghun.portfolio.presentation.dto.IntroductionDTO
import com.yeonghun.portfolio.presentation.dto.LinkDTO
import com.yeonghun.portfolio.presentation.dto.ProjectDTO
import com.yeonghun.portfolio.presentation.dto.ResumeDTO
import com.yeonghun.portfolio.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : com.yeonghun.portfolio.presentation.controller
 * fileName       : PresentationApiController
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
@RestController
@RequestMapping("/api")
class PresentationApiController (
    private val presentationService: PresentationService
){
    @GetMapping("/test")
    fun test(): String = "OK"

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> =
        presentationService.getIntroductions()

    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO> =
        presentationService.getLinks()

    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO =
        presentationService.getResume()

    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO> =
        presentationService.getProjects()
}