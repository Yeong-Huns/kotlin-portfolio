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
class ExperienceDetail(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "experience_detail_id")
    val id: Long? = null,
    var content: String,
    var isActive: Boolean,
): BaseEntity()