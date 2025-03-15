package com.yeonghun.portfolio.admin.context.skill.controller

import com.yeonghun.portfolio.admin.context.skill.service.AdminSkillService
import com.yeonghun.portfolio.admin.data.FormElementDTO
import com.yeonghun.portfolio.admin.data.SelectFormElementDTO
import com.yeonghun.portfolio.admin.data.TextFormElementDTO
import com.yeonghun.portfolio.domain.constant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

/**
 *packageName    : com.yeonghun.portfolio.admin.context.achievement.controller
 * fileName       : AdminAchievemnetViewController
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@Controller
@RequestMapping("/admin/skill")
class AdminSkillViewController (
    private val adminSkillService: AdminSkillService,
){
    @GetMapping
    fun getLink(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("name", 2),
            SelectFormElementDTO("type", 2, SkillType.entries.map {it.name}.toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("formElements", formElements)

        val table = adminSkillService.getSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            "menuName" to "Resume",
            "PageName" to table.name,
            "editable" to true,
            "deletable" to false,
            "hasDetails" to false,
        )
        model.addAllAttributes(pageAttributes)
        return "admin/page-table"
    }
}