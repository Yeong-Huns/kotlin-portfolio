package com.yeonghun.portfolio.presentation.controller

import com.yeonghun.portfolio.domain.constant.SkillType
import com.yeonghun.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

/**
 *packageName    : com.yeonghun.portfolio.presentation.controller
 * fileName       : PresentationViewController
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
@Controller
class PresentationViewController (
    private val presentationService: PresentationService,
){
    @GetMapping("/test")
    fun test(): String = "test"

    @GetMapping("/")
    fun index(model: Model): String {
        val intorductions = presentationService.getIntroductions()
        model.addAttribute("introductions", intorductions)

        val links = presentationService.getLinks()
        model.addAttribute("links", links)

        return "presentation/index"
    }

    @GetMapping("/resume")
    fun resume(model: Model): String {
        val resume = presentationService.getResume()
        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.entries.toTypedArray())

        return "presentation/resume"
    }

    @GetMapping("/projects")
    fun projects(model: Model): String {
        val projects = presentationService.getProjects()
        model.addAttribute("projects", projects)
        return "presentation/projects"
    }
}