package com.project.trade.coupon.domain

import java.time.LocalDateTime

data class Corporation(
    val corporationName: String? = null,

    val businessNo: String,

    val provinceCode: Int,

    val cityDistrictCode: Int,

    val townCode: Int,

    val basedAt: LocalDateTime,
)