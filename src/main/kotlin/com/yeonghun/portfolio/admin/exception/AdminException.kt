package com.yeonghun.portfolio.admin.exception

import jdk.internal.joptsimple.internal.Messages.message
import org.springframework.http.HttpStatus

/**
 *packageName    : com.yeonghun.portfolio.admin.exception
 * fileName       : AdminException
 * author         : Yeong-Huns
 * date           : 2025-03-14
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-14        Yeong-Huns       최초 생성
 */
abstract class AdminException (
    val httpStatus: HttpStatus,
    message: String,
): RuntimeException(message)

class AdminBadRequestException(message: String) : AdminException(HttpStatus.BAD_REQUEST, message)

class AdminInternalServerException(message: String) : AdminException(HttpStatus.INTERNAL_SERVER_ERROR, message)