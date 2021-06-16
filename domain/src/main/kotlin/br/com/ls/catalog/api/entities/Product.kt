package br.com.ls.catalog.api.entities

import java.math.BigDecimal
import java.time.LocalDate

data class Product(
        val id: Long,
        val name: String,
        val sku: String,
        val unitPrice: BigDecimal,
        val thumbUrl: String,
        val itemType: String, // TODO
        val active: Boolean,
        val allowedSaleToPerson: Boolean,
        val allowedSaleToCompany: Boolean,
        val installmentsMaxNumber: Int,
        val createdAt: LocalDate,
        val updatedAt: LocalDate
)