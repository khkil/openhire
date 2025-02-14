package com.project.openhire.company.application.port.out

import com.project.openhire.company.domain.Corporation

interface ReadExcelFilePort {
    fun readCorporationExcelFile(limitSize: Int = 10): List<Corporation>
}