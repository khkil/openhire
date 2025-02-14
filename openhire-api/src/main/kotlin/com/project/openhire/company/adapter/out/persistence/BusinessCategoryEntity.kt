package com.project.openhire.company.adapter.out.persistence

import jakarta.persistence.*


@Entity
@Table(name = "BUSINESS_CATEGORY")
class BusinessCategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val categoryCode: Int,

    @Column(unique = true, nullable = false)
    val categoryName: String,

    @OneToMany(mappedBy = "businessCategory")
    val corporations: List<CorporationEntity>? = mutableListOf()
)
