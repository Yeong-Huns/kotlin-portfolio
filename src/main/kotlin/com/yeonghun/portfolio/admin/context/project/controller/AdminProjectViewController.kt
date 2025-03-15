package com.yeonghun.portfolio.admin.context.project.controller

import com.yeonghun.portfolio.admin.context.project.service.AdminProjectService
import com.yeonghun.portfolio.admin.data.FormElementDTO
import com.yeonghun.portfolio.admin.data.SelectFormElementDTO
import com.yeonghun.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 *packageName    : com.yeonghun.portfolio.admin.context.project.controller
 * fileName       : AdminExperienceViewController
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@Controller
@RequestMapping("/admin/project")
class AdminProjectViewController (
    private val adminProjectService: AdminProjectService
){
    @GetMapping
    fun experience(model: Model): String {
        val formElement = listOf<FormElementDTO>(
            TextFormElementDTO("name", 4),
            TextFormElementDTO("description", 8),
            SelectFormElementDTO("startYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("startMonth", 2, (1..12).toList()),
            SelectFormElementDTO("endYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("endMonth", 2, (1..12).toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("formElement", formElement)

        val detailFormElement = listOf<FormElementDTO>(
            TextFormElementDTO("content", 4),
            TextFormElementDTO("url", 6),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("detailFormElement", detailFormElement)

        val table = adminProjectService.getProjectTable()
        model.addAttribute("table", table)

        val detailTable = adminProjectService.getProjectDetailTable(null)
        model.addAttribute("detailTable", detailTable)

        val pageAttributes = mutableMapOf<String, Any>(
            "menuName" to "Projects",
            "pageName" to table.name,
            "editable" to true,
            "deletable" to false,
            "hasDetails" to true
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}