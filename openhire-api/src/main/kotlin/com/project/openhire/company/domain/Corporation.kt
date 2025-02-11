package com.project.trade.coupon.domain

import lombok.NoArgsConstructor
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

    val basedAt: LocalDate? = null,

){
    companion object {
        fun convertFromRow(row: Row) : Corporation {
            val date: Date = row.getCell(0).dateCellValue
            return Corporation(
                corporationName = row.getCell(1).stringCellValue,
                businessNo = row.getCell(2).numericCellValue.toInt(),
                provinceCode = row.getCell(9).numericCellValue.toInt(),
                cityDistrictCode = row.getCell(10).numericCellValue.toInt(),
                townCode = row.getCell(10).numericCellValue.toInt(),
                basedAt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
            );
        }
    }
}