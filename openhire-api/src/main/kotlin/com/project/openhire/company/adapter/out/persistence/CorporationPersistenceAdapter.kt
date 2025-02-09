package com.project.openhire.company.adapter.out.persistence

import com.project.openhire.common.annotations.PersistenceAdapter
import com.project.openhire.company.application.port.out.ReadExcelFilePort
import com.project.trade.coupon.domain.Corporation
import org.springframework.beans.factory.annotation.Value

@PersistenceAdapter
class CorporationPersistenceAdapter : ReadExcelFilePort {
    @Value("\${file.data.corporation-excel-file}")
    lateinit var excelFilePath: String

    override fun readCorporationExcelFile(limitSize: Int): List<Corporation> {
        println(limitSize)
        println(excelFilePath)
        return listOf()
    }
}