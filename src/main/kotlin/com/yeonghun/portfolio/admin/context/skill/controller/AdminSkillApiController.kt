package com.yeonghun.portfolio.admin.context.skill.controller

import com.yeonghun.portfolio.admin.context.skill.form.SkillForm
import com.yeonghun.portfolio.admin.context.skill.service.AdminSkillService
import com.yeonghun.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : com.yeonghun.portfolio.admin.context.skill.controller
 * fileName       : AdminSkillApiController
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@RestController
@RequestMapping("/admin/api/skills")
class AdminSkillApiController (
    private val adminSkillService: AdminSkillService
){
    @PostMapping
    fun postSkill(@RequestBody @Validated form: SkillForm) : ResponseEntity<Any>{
        adminSkillService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putSkill(@PathVariable id: Long, @RequestBody @Validated form: SkillForm) : ResponseEntity<Any>{
        adminSkillService.update(id, form)
        return ApiResponse.successUpdate()
    }
}