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
class Experience(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "experience_id")
    val id: Long? = null,
    var title: String,
    var description: String,
    var startYear: Int,
    var startMonth: Int,
    var endYear: Int?,
    var endMonth: Int?,
    var isActive: Boolean,
    @OneToMany(targetEntity = ExperienceDetail::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "experience_id")
    val details: MutableList<ExperienceDetail> = mutableListOf(),
) : BaseEntity() {
    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }
        return "$endYear.$endMonth"
    }

    /* 맘에안듬.. DTO 받던가하면 더 깔끔하지 않나 */
    fun update(title: String, description: String, startYear: Int, startMonth: Int, endYear: Int?, endMonth: Int?, isActive: Boolean) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(experienceDetails: MutableList<ExperienceDetail>?) {
        if(!experienceDetails.isNullOrEmpty()) {
            this.details.addAll(experienceDetails)
        }
    }
}