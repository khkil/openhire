package com.project.openhire.company.application.service

import com.project.openhire.company.application.port.`in`.BatchCorporationImportUseCase
import com.project.openhire.company.application.port.out.ReadExcelFilePort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CorporationService(
    private val readExcelFilePort: ReadExcelFilePort
) : BatchCorporationImportUseCase {
    override fun batchCorporationImport() {
        readExcelFilePort.readCorporationExcelFile(50)
        println("import")
    }
}