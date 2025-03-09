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
class Project(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "project_id")
    val id: Long? = null,
    var name: String,
    var description: String,
    var startYear: Int,
    var startMonth: Int,
    var endYear: Int?,
    var endMonth: Int?,
    var isActive: Boolean,
    @OneToMany(targetEntity = ProjectDetail::class, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "project_id")
    val details: MutableList<ProjectDetail> = mutableListOf(),
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val skills: MutableList<ProjectSkill> = mutableListOf(),
): BaseEntity() {
    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }
        return "$endYear.$endMonth"
    }

    /* 맘에안듬.. DTO 받던가하면 더 깔끔하지 않나 */
    fun update(name: String, description: String, startYear: Int, startMonth: Int, endYear: Int?, endMonth: Int?, isActive: Boolean) {
        this.name = name
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(projectDetails: MutableList<ProjectDetail>?) {
        if(!projectDetails.isNullOrEmpty()) {
            this.details.addAll(projectDetails)
        }
    }
}