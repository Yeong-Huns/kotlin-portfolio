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
abstract class FormElementDTO (
    val name: String,
    val size: Int,
    val type: String
)

class TextFormElementDTO (
    name: String,
    size: Int,
): FormElementDTO(name, size, "text")

class DateFormElementDTO (
    name: String,
    size: Int,
): FormElementDTO(name, size, "date")

class SelectFormElementDTO (
    name: String,
    size: Int,
    val options: List<Any>
): FormElementDTO(name, size, "select"){
}