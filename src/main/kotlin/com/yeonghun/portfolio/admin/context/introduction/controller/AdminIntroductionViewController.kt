package com.yeonghun.portfolio.admin.context.introduction.controller

import com.yeonghun.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.yeonghun.portfolio.admin.data.DateFormElementDTO
import com.yeonghun.portfolio.admin.data.FormElementDTO
import com.yeonghun.portfolio.admin.data.SelectFormElementDTO
import com.yeonghun.portfolio.admin.data.TextFormElementDTO
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
@RequestMapping("/admin/introduction")
class AdminIntroductionViewController (
    private val adminIntroductionService: AdminIntroductionService
){
    @GetMapping
    fun getIntroduction(model: Model): String {
        val formElements = listOf<FormElementDTO>(
            TextFormElementDTO("content", 10),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString())),
        )
        model.addAttribute("formElements", formElements)

        val table = adminIntroductionService.getIntroductionTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            "menuName" to "Index",
            "PageName" to table.name,
            "editable" to true,
            "deletable" to false,
            "hasDetails" to false,
        )
        model.addAllAttributes(pageAttributes)
        return "admin/page-table"
    }
}