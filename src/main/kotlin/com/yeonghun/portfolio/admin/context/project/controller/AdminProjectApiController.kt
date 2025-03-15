package com.yeonghun.portfolio.admin.context.project.controller

import com.yeonghun.portfolio.admin.context.project.form.ProjectForm
import com.yeonghun.portfolio.admin.context.project.service.AdminProjectService
import com.yeonghun.portfolio.admin.data.ApiResponse
import com.yeonghun.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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
@RequestMapping("/admin/api/projects")
class AdminProjectApiController (
    private val adminProjectService: AdminProjectService
){
    @PostMapping
    fun postExperience(@RequestBody @Validated form: ProjectForm): ResponseEntity<Any> {
        adminProjectService.save(form)
        return ApiResponse.successCreate()
    }

    @PostMapping("/{id}")
    fun putExperience(@PathVariable id:Long, @RequestBody @Validated form: ProjectForm): ResponseEntity<Any> {
        adminProjectService.update(id, form)
        return ApiResponse.successUpdate()
    }

    @GetMapping("/{id}/details")
    fun getExperienceDetail(@PathVariable id:Long): TableDTO =
        adminProjectService.getProjectDetailTable(id)

}