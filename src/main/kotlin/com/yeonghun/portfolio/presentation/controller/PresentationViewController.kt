package com.yeonghun.portfolio.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 *packageName    : com.yeonghun.portfolio.presentation.controller
 * fileName       : PresentationViewController
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
@Controller
class PresentationViewController {
    @GetMapping("/test")
    fun test(): String = "test"
}