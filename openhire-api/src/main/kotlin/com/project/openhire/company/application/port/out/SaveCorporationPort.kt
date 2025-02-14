package com.project.openhire.company.application.port.out

import com.project.openhire.company.adapter.out.persistence.BusinessCategoryEntity
import com.project.openhire.company.domain.BusinessCategory
import com.project.openhire.company.domain.Corporation

interface SaveCorporationPort {
    fun saveCorporationPort(corporation: Corporation)
    fun saveCorporationCategory(businessCategory: BusinessCategory): BusinessCategoryEntity
}