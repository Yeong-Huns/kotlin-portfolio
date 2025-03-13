package com.yeonghun.portfolio.admin.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 *packageName    : com.yeonghun.portfolio.admin.interceptor
 * fileName       : AdminInterceptorConfig
 * author         : Yeong-Huns
 * date           : 2025-03-14
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-14        Yeong-Huns       최초 생성
 */
@Configuration
class AdminInterceptorConfig (
    val adminInterceptor: AdminInterceptor
): WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {

    }
}