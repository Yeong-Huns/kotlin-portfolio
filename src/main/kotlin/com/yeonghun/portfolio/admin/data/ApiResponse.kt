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
class ApiResponse<T>(status: HttpStatus) : ResponseEntity<T>(status) {
    companion object {
        fun successCreate(): ResponseEntity<Any> =
            ResponseEntity.status(HttpStatus.CREATED).body("데이터가 저장되었습니다.")

        fun successUpdate(): ResponseEntity<Any> =
            ResponseEntity.ok("데이터가 수정되었습니다.")

        fun successDelete(): ResponseEntity<Any> =
            ResponseEntity.ok("데이터가 삭제되었습니다.")
    }
}