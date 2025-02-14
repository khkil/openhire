package com.project.openhire.company.domain

import com.project.openhire.company.adapter.out.persistence.BusinessCategoryEntity
import com.project.openhire.company.adapter.out.persistence.CorporationEntity
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

data class Corporation(
    val corporationName: String,

    val businessNo: Int,

    val provinceCode: Int,

    val cityDistrictCode: Int,

    val townCode: Int,

    val basedAt: LocalDate,

    var businessCategory: BusinessCategoryEntity? = null,
) {
    fun setCategory(businessCategory: BusinessCategoryEntity) {
        this.businessCategory = businessCategory
    }


    companion object {
        fun convertFromRow(row: Row): Corporation {
            val date: Date = row.getCell(0).dateCellValue
            val corporationName: String = parseCorporationName(row.getCell(1).stringCellValue)

            return Corporation(
                corporationName = corporationName,
                businessNo = row.getCell(2).numericCellValue.toInt(),
                provinceCode = row.getCell(9).numericCellValue.toInt(),
                cityDistrictCode = row.getCell(10).numericCellValue.toInt(),
                townCode = row.getCell(10).numericCellValue.toInt(),
                basedAt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            )
        }


        fun toEntity(corporation: Corporation): CorporationEntity {
            return CorporationEntity(
                corporationName = corporation.corporationName,
                businessNo = corporation.businessNo,
                provinceCode = corporation.provinceCode,
                cityDistrictCode = corporation.cityDistrictCode,
                townCode = corporation.townCode,
                basedAt = corporation.basedAt,
                createAt = LocalDateTime.now(),
                businessCategory = corporation.businessCategory,
            )
        }

        private fun parseCorporationName(corporationName: String): String {
            return corporationName
                .replace(Regex("\\(.*?\\)"), "")
                .replace("주식회사", "")
        }
    }
}


data class BusinessCategory(
    val categoryCode: Int,
    val categoryName: String,
) {
    companion object {

        fun convertFromRow(row: Row): BusinessCategory? {

            val categoryCode: Int? = if (row.getCell(13).cellType == CellType.STRING) null else row.getCell(13)?.numericCellValue?.toInt()
            val categoryName: String? = row.getCell(14)?.stringCellValue

            if (categoryCode == null || categoryName == null) {
                return null
            }

            return BusinessCategory(
                categoryCode = categoryCode,
                categoryName = categoryName
            )
        }

        fun toEntity(businessCategory: BusinessCategory): BusinessCategoryEntity {
            return BusinessCategoryEntity(
                categoryCode = businessCategory.categoryCode,
                categoryName = businessCategory.categoryName,
            )
        }
    }
}