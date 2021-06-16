package br.com.ls.catalog.api.entities.database

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.math.BigDecimal
import java.time.LocalDate
import br.com.ls.catalog.api.entities.model.Product as ProductModel

@Document("produto")
data class Product(

        @Id
        val id: Long,

        @Field("nomeProduto")
        val name: String,

        @Field("codigoSKU")
        val sku: String,

        @Field("valorUnitario")
        val unitPrice: BigDecimal,

        @Field("imagem")
        val thumbUrl: String,

        @Field("tipoProduto")
        val itemType: String, // TODO

        @Field("produtoAtivo")
        val active: Boolean,

        @Field("permiteVendaPessoaFisica")
        val allowedSaleToPerson: Boolean,

        @Field("permiteVendaPessoaJuridica")
        val allowedSaleToCompany: Boolean,

        @Field("qtdMaxParcelas")
        val installmentsMaxNumber: Int,

        @CreatedDate
        @Field("dataCriacao")
        val createdAt: LocalDate,

        @LastModifiedDate
        @Field("dataAtualizacao")
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