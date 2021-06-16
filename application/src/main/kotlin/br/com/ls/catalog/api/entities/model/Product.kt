package br.com.ls.catalog.api.entities.model

import java.math.BigDecimal
import java.time.LocalDate
import br.com.ls.catalog.api.entities.database.Product as ProductDatabase

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
) {
    companion object {
        fun toEntity(product: Product): ProductDatabase {
            return ProductDatabase(
                    id = product.id,
                    name = product.name,
                    sku = product.sku,
                    unitPrice = product.unitPrice,
                    thumbUrl = product.thumbUrl,
                    itemType = product.itemType,
                    active = product.active,
                    allowedSaleToPerson = product.allowedSaleToPerson,
                    allowedSaleToCompany = product.allowedSaleToCompany,
                    installmentsMaxNumber = product.installmentsMaxNumber,
                    createdAt = product.createdAt,
                    updatedAt = product.updatedAt
            )
        }
    }
}