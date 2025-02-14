package com.project.openhire.company.adapter.out.persistence

import com.project.openhire.common.annotations.PersistenceAdapter
import com.project.openhire.company.application.port.out.ReadExcelFilePort
import com.project.openhire.company.application.port.out.SaveCorporationPort
import com.project.openhire.company.domain.BusinessCategory
import com.project.openhire.company.domain.Corporation
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.util.IOUtils
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.beans.factory.annotation.Value
import java.io.FileInputStream

@PersistenceAdapter
class CorporationPersistenceAdapter(
    private val businessCategoryRepository: BusinessCategoryRepository,
    private val corporationRepository: CorporationRepository,
) : ReadExcelFilePort, SaveCorporationPort {
    @Value("\${file.data.corporation-excel-file}")
    lateinit var excelFilePath: String

    override fun readCorporationExcelFile(limitSize: Int): List<Corporation> {
        IOUtils.setByteArrayMaxOverride(1000000000)
        val file: FileInputStream = FileInputStream(excelFilePath) // 파일 읽기
        val excelFile: XSSFWorkbook = XSSFWorkbook(file)
        val sheet = excelFile.getSheetAt(0)

        val corporationList = mutableListOf<Corporation>()

        for (row: Row in sheet) {
            if (row.rowNum == 0) {
                continue
            }

            val corporation: Corporation = Corporation.convertFromRow(row);

            val businessCategory: BusinessCategory? = BusinessCategory.convertFromRow(row)
            if (businessCategory != null) {
                corporation.setCategory(saveCorporationCategory(businessCategory))
            }

            corporationList.add(corporation)
        }

        for (corporation: Corporation in corporationList) {
            val corporationName = corporation.corporationName
            if (corporationName.contains("토스")) {
                println(corporation.corporationName)
            }
        }
        return corporationList;
    }

    override fun saveCorporationPort(corporation: Corporation) {
        TODO("Not yet implemented")
    }

    override fun saveCorporationCategory(businessCategory: BusinessCategory): BusinessCategoryEntity {
        val params: BusinessCategoryEntity = BusinessCategory.toEntity(businessCategory)
        val businessCategoryEntity = businessCategoryRepository.findByCategoryCode(params.categoryCode);

        return businessCategoryEntity ?: businessCategoryRepository.save(params)
    }
}