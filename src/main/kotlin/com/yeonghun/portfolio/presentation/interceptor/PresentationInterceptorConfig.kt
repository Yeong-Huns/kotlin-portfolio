package com.yeonghun.portfolio.presentation.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 *packageName    : com.yeonghun.portfolio.presentation.interceptor
 * fileName       : PresentationInterceptor
 * author         : Yeong-Huns
 * date           : 2025-03-12
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-12        Yeong-Huns       최초 생성
 */
@Configuration
class PresentationInterceptorConfig(
    private val presentationInterceptor: PresentationInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(presentationInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns("/assets/**", "/css/**", "/js/**", "/admin/**", "h2**", "/favicon.ico", "/error")
    }
}