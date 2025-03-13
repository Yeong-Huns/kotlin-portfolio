package com.yeonghun.portfolio.admin.data

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
class TableDTO(
    val name: String,
    val columns: List<String>,
    val records: List<List<String>>
) {
}