package com.project.trade.coupon.adapter.out.persistence

import com.project.openhire.company.adapter.out.persistence.CorporationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CorporationRepository : JpaRepository<CorporationEntity, Long> {
}