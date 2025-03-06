package com.yeonghun.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

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
class Achievement(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "achievement_id")
    val id: Long? = null,
    var title: String,
    var description: String,
    var achievedDate: LocalDate? = null,
    var host: String,
    var isActive: Boolean,
): BaseEntity()