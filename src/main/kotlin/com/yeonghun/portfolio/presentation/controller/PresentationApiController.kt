package com.yeonghun.portfolio.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *packageName    : com.yeonghun.portfolio.presentation.controller
 * fileName       : PresentationApiController
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
@RestController
@RequestMapping("/api")
class PresentationApiController {
    @GetMapping("/test")
    fun test(): String = "OK"
}