package com.yeonghun.portfolio.admin.advice

import com.yeonghun.portfolio.admin.exception.AdminException
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 *packageName    : com.yeonghun.portfolio.admin.advice
 * fileName       : AdminApiControllerAdvice
 * author         : Yeong-Huns
 * date           : 2025-03-14
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-14        Yeong-Huns       최초 생성
 */
val logger = KotlinLogging.logger {}

@RestControllerAdvice
class AdminApiControllerAdvice {
    @ExceptionHandler
    fun handleException(exception: AdminException): ResponseEntity<String> {
        logger.info { "${exception.message}, $exception" }
        return ResponseEntity.status(exception.httpStatus).body(exception.message)
    }

    @ExceptionHandler
    fun handleException(exception: MethodArgumentNotValidException): ResponseEntity<String> {
        logger.info { "${exception.message}, $exception" }
        val fieldError = exception.bindingResult.fieldErrors[0]
        val message = "[${fieldError.field}] ${fieldError.defaultMessage}]"
        return ResponseEntity.badRequest().body(message)
    }

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<String>  {
        logger.info { "${exception.message}, $exception" }
        return ResponseEntity.internalServerError().body("시스템 오류가 발생했습니다.")
    }
}