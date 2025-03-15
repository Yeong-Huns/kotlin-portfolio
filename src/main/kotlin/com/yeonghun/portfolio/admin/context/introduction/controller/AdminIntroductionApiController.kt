package com.yeonghun.portfolio.admin.context.introduction.controller

import com.yeonghun.portfolio.admin.context.introduction.form.IntroductionForm
import com.yeonghun.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.yeonghun.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 *packageName    : com.yeonghun.portfolio.admin.context.introduction.controller
 * fileName       : AdminIntroductionApiController
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@RestController
@RequestMapping("/admin/api/introductions")
class AdminIntroductionApiController (
    private val adminIntroductionService: AdminIntroductionService
){
    @PostMapping
    fun postIntroduction(@RequestBody @Validated form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putIntroduction(@PathVariable id: Long, @RequestBody @Validated form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.update(id, form)
        return ApiResponse.successUpdate()
    }

}