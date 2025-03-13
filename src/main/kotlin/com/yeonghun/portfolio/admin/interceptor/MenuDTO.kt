package com.yeonghun.portfolio.admin.interceptor

/**
 *packageName    : com.yeonghun.portfolio.admin.interceptor
 * fileName       : MenuDTO
 * author         : Yeong-Huns
 * date           : 2025-03-14
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-14        Yeong-Huns       최초 생성
 */
data class MenuDTO (
    val name: String,
    val pages: List<PageDTO>
)