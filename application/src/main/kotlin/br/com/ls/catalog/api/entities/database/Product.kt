package br.com.ls.catalog.api.entities.database

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate
import br.com.ls.catalog.api.entities.model.Product as ProductModel

@Document
data class Product(
        @Id
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
        @CreatedDate
        val createdAt: LocalDate,
        @LastModifiedDate
        val updatedAt: LocalDate
) {
        companion object {
                fun toModel(product: Product): ProductModel {
                        return ProductModel(
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