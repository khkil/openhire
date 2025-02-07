package com.project.openhire.company.adapter.out.persistence

import jakarta.persistence.*


@Entity
@Table(name = "BUSINESS_CATEGORY")
class BusinessCategoryEntity {
    @Id
    val id: Long? = null

    @Column
    val categoryCode: Int? = null

    val categoryName: String? = null

    @OneToMany(mappedBy = "businessCategory")
    val corporations: List<CorporationEntity> = ArrayList()
}
