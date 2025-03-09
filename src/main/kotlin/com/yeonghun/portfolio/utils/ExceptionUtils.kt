package com.yeonghun.portfolio.utils

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull

/**
 *packageName    : com.yeonghun.portfolio.utils
 * fileName       : ExceptionUtils
 * author         : Yeong-Huns
 * date           : 2025-03-09
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-09        Yeong-Huns       최초 생성
 */

inline fun<reified T, ID> CrudRepository<T, ID>.findByIdOrThrow(id: ID): T {
    return this.findByIdOrNull(id) ?: throw IllegalArgumentException("[${T::class.simpleName}] $id 조회에 실패했습니다.")
}