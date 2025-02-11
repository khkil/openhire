package com.project.openhire.company.application.port.out

import com.project.trade.coupon.domain.Corporation

interface ReadExcelFilePort {
    fun readCorporationExcelFile(limitSize: Int = 10): List<Corporation>
    fun parseCorporationName(corporationName: String): String
}