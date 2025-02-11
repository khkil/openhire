package com.project.openhire.company.application.service

import com.project.openhire.common.annotations.UseCase
import com.project.openhire.company.application.port.`in`.BatchCorporationImportUseCase
import com.project.openhire.company.application.port.out.ReadExcelFilePort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@UseCase
class CorporationService(
    private val readExcelFilePort: ReadExcelFilePort
) : BatchCorporationImportUseCase {
    override fun batchCorporationImport() {
        readExcelFilePort.readCorporationExcelFile(50)
        println("import")
    }
}