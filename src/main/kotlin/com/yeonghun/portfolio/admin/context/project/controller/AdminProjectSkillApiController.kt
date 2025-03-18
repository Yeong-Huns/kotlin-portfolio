package com.yeonghun.portfolio.admin.context.project.controller

import com.yeonghun.portfolio.admin.context.project.form.ProjectSkillForm
import com.yeonghun.portfolio.admin.context.project.service.AdminProjectSkillService
import com.yeonghun.portfolio.admin.data.ApiResponse
import com.yeonghun.portfolio.domain.entity.ProjectSkill
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : com.yeonghun.portfolio.admin.context.project.controller
 * fileName       : AdminProjectSkillApiController
 * author         : Yeong-Huns
 * date           : 2025-03-18
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-18        Yeong-Huns       최초 생성
 */
@RestController
@RequestMapping("/admin/api/projects/skills")
class AdminProjectSkillApiController (
    private val adminProjectSkillService: AdminProjectSkillService
){
    @PostMapping
    fun postProjectSkill(@RequestBody @Validated projectSkillForm: ProjectSkillForm): ResponseEntity<Any> {
        adminProjectSkillService.save(projectSkillForm)
        return ApiResponse.successCreate()
    }

    @DeleteMapping("/{id}")
    fun deleteProjectSkill(@PathVariable id: Long): ResponseEntity<Any> {
        adminProjectSkillService.delete(id)
        return ApiResponse.successDelete()
    }
}