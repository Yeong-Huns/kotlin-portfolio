package com.yeonghun.portfolio.admin.context.experience.controller

import com.yeonghun.portfolio.admin.context.experience.form.ExperienceForm
import com.yeonghun.portfolio.admin.context.experience.service.AdminExperienceService
import com.yeonghun.portfolio.admin.data.ApiResponse
import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.domain.entity.Experience
import com.yeonghun.portfolio.domain.entity.ExperienceDetail
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : com.yeonghun.portfolio.admin.context.experience.controller
 * fileName       : AdminExperienceApiController
 * author         : Yeong-Huns
 * date           : 2025-03-16
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-16        Yeong-Huns       최초 생성
 */
@RestController
@RequestMapping("/admin/api/experiences")
class AdminExperienceApiController (
    private val adminExperienceService: AdminExperienceService
){
    @PostMapping
    fun postExperience(@RequestBody @Validated form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.save(form)
        return ApiResponse.successCreate()
    }

    @PostMapping("/{id}")
    fun putExperience(@PathVariable id:Long, @RequestBody @Validated form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.update(id, form)
        return ApiResponse.successUpdate()
    }

    @GetMapping("/{id}/details")
    fun getExperienceDetail(@PathVariable id:Long): TableDTO =
        adminExperienceService.getExperienceDetailTable(id)

}