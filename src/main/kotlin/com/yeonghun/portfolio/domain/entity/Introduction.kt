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
class Introduction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "introduction_id")
    val id: Long? = null,
    var content: String? = null,
    var isActive: Boolean,
): BaseEntity()