package com.yeonghun.portfolio.presentation.interceptor


import com.yeonghun.portfolio.domain.entity.HttpInterface
import com.yeonghun.portfolio.domain.repository.HttpInterfaceRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

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
@Component
class PresentationInterceptor(
    private val httpInterfaceRepository: HttpInterfaceRepository
): HandlerInterceptor {
    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        val httpInterface = HttpInterface(httpServletRequest = request)
        httpInterfaceRepository.save(httpInterface)
    }
}