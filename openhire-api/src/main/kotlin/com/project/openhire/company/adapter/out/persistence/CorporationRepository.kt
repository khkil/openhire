package com.project.openhire.company.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface CorporationRepository : JpaRepository<CorporationEntity, Long> {
}