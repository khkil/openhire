package com.project.openhire.company.adapter.out.persistence

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "CORPORATION")
class CorporationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    val corporationName: String,

    val businessNo: Int,

    val provinceCode: Int,

    val cityDistrictCode: Int,

    val townCode: Int,

    val basedAt: LocalDate,

    val createAt: LocalDateTime,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val businessCategory: BusinessCategoryEntity? = null,
)
