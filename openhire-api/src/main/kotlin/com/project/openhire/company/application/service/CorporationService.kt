package com.project.openhire.company.application.service

import com.project.openhire.common.annotations.UseCase
import com.project.openhire.company.application.port.`in`.BatchCorporationImportUseCase
import com.project.openhire.company.application.port.out.ReadExcelFilePort
import com.project.openhire.company.domain.Corporation

@UseCase
class CorporationService(
    private val readExcelFilePort: ReadExcelFilePort
) : BatchCorporationImportUseCase {
    override fun batchCorporationImport() {
        val corporationList: List<Corporation> = readExcelFilePort.readCorporationExcelFile(50)
        println("import")

    }
}