package com.project.openhire.company.adapter.out.persistence

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "CORPORATION")
class CorporationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null

    val corporationName: String? = null

    val businessNo: String? = null

    val provinceCode: Int? = null

    val cityDistrictCode: Int? = null

    val townCode: Int? = null

    val basedAt: LocalDateTime? = null

    val createAt: LocalDateTime = LocalDateTime.now()

    @ManyToOne
    val businessCategory: BusinessCategoryEntity = BusinessCategoryEntity()
}
