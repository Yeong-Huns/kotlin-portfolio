package com.yeonghun.portfolio.domain.entity

import jakarta.persistence.*

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
class ProjectDetail(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "project_detail_id")
    val id: Long? = null,
    var content: String,
    var isActive: Boolean,
    var url: String? = null,
): BaseEntity() {
    fun update(content: String, isActive: Boolean, url: String?) {
        this.content = content
        this.isActive = isActive
        this.url = url
    }
}