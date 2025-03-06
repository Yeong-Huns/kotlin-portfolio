package com.yeonghun.portfolio.domain.entity

import com.yeonghun.portfolio.domain.constant.SkillType
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
class Skill(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "skill_id")
    val id: Long? = null,

    var name: String,

    @Enumerated(EnumType.STRING) @Column(name = "skill_type")
    var type: SkillType,

    var isActive: Boolean,
): BaseEntity()