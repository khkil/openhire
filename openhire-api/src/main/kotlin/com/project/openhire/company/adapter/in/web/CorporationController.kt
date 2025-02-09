package com.project.openhire.company.adapter.`in`.web

import com.project.openhire.company.application.port.`in`.BatchCorporationImportUseCase
import com.project.trade.coupon.domain.Corporation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/corporation")
class CorporationController(
    private val batchCorporationImportUseCase: BatchCorporationImportUseCase,
) {
    @PostMapping("/import")
    fun import(): ResponseEntity<Any> {
        batchCorporationImportUseCase.batchCorporationImport()
        return ResponseEntity.ok().build()
    }

}