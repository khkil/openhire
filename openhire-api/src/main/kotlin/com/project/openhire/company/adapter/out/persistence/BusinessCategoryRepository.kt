package com.project.openhire.company.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface BusinessCategoryRepository : JpaRepository<BusinessCategoryEntity, Long> {
    fun findByCategoryCode(categoryCode: Int): BusinessCategoryEntity?
}