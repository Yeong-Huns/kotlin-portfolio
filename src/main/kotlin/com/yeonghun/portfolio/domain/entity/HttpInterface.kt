package com.yeonghun.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

/**
 *packageName    : com.yeonghun.portfolio.domain.entity
 * fileName       : Achievement
 * author         : Yeong-Huns
 * date           : 2025-03-06
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-06        Yeong-Huns       최초 생성
 */
@Entity
class HttpInterface(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "http_interface_id")
    val id: Long? = null,
    var cookies: String? = null,
    var referer: String? = null,
    var localAddr: String? = null,
    var remoteAddr: String? = null,
    var requestUri: String? = null,
    var userAgent: String? = null,
    httpServletRequest: HttpServletRequest,
): BaseEntity(){
    init {
        this.cookies = httpServletRequest.cookies
            ?.map { "${it.name}:${it.value}" }
            ?.toString()
        this.referer = httpServletRequest.getHeader("referer")
        this.localAddr = httpServletRequest.localAddr
        this.remoteAddr = httpServletRequest.remoteAddr
        this.requestUri = httpServletRequest.requestURI
        this.userAgent = httpServletRequest.getHeader("user-agent")
    }
}