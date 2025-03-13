package com.yeonghun.portfolio.admin.data

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

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
    companion object {
        fun<T: Any> of(classInfo: KClass<T>, entities: List<Any>, vararg filterings: String): TableDTO {
            val name = classInfo.simpleName ?: "Unknown"
            val columns = createColumns(classInfo, *filterings)
            val records = entities.map { entity ->
                columns.map { column ->
                    classInfo.memberProperties
                        .find { column == it.name }
                        ?.getter
                        ?.call(entity)
                        .toString()
                }.toList()
            }.toList()
            return TableDTO(name, columns, records)
        }
        private fun <T: Any> createColumns(classInfo: KClass<T>, vararg filterings: String): MutableList<String> {
            val mainColumns = classInfo.java.declaredFields
                .filter { !filterings.contains(it.name) }
                .map { it.name }
                .toMutableList()
            val baseColumns = classInfo.java.declaredFields
                .map { it.name }
                .toMutableList()

            return (mainColumns + baseColumns).toMutableList()
        }
    }
}