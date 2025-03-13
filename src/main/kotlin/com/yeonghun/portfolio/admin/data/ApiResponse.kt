package com.yeonghun.portfolio.admin.data

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 *packageName    : com.yeonghun.portfolio.admin.data
 * fileName       : ApiResponse
 * author         : Yeong-Huns
 * date           : 2025-03-14
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-14        Yeong-Huns       최초 생성
 */
class ApiResponse<T>(status: HttpStatus): ResponseEntity<T>(status)