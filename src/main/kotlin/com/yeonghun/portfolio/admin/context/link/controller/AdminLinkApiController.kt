package com.yeonghun.portfolio.admin.context.link.controller

import com.yeonghun.portfolio.admin.context.link.form.LinkForm
import com.yeonghun.portfolio.admin.context.link.service.AdminLinkService
import com.yeonghun.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 *packageName    : com.yeonghun.portfolio.admin.context.link.controller
 * fileName       : AdminLinkApiController
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@RestController
@RequestMapping("/admin/api/links")
class AdminLinkApiController (
    private val adminLinkService: AdminLinkService
){
    @PostMapping
    fun postLink(@RequestBody @Validated form: LinkForm): ResponseEntity<Any>{
        adminLinkService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putLink(@PathVariable id: Long,@RequestBody @Validated form: LinkForm): ResponseEntity<Any>{
        adminLinkService.update(id, form)
        return ApiResponse.successUpdate()
    }
}