package com.project.openhire.company.adapter.out.persistence

import com.project.openhire.common.annotations.PersistenceAdapter
import com.project.openhire.company.application.port.out.ReadExcelFilePort
import com.project.trade.coupon.domain.Corporation
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.beans.factory.annotation.Value
import java.io.FileInputStream
import java.util.Date

@PersistenceAdapter
class CorporationPersistenceAdapter : ReadExcelFilePort {
    @Value("\${file.data.corporation-excel-file}")
    lateinit var excelFilePath: String

    override fun readCorporationExcelFile(limitSize: Int): List<Corporation> {
        val file: FileInputStream = FileInputStream(excelFilePath) // 파일 읽기
        val excelFile : XSSFWorkbook = XSSFWorkbook(file)
        val sheet = excelFile.getSheetAt(0)

        val corporationList = mutableListOf<Corporation>()

        for(row: Row in sheet) {
            if(row.rowNum == 0) {
                continue
            }

            val corporation: Corporation = Corporation.convertFromRow(row);
            corporationList.add(corporation)

        }
        return corporationList;
    }

    override fun parseCorporationName(corporationName: String): String {
        TODO("Not yet implemented")
    }
}