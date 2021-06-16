package br.com.ls.catalog.api.controllers

import br.com.ls.catalog.api.gateways.mongo.GetProductByIdMongo
import br.com.ls.catalog.api.gateways.mongo.GetProductsMongo
import br.com.ls.catalog.api.gateways.mongo.SaveProductMongo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import br.com.ls.catalog.api.entities.model.Product as ProductModel

@RestController
@RequestMapping("/products")
class CatalogController(
        val saveProductMongo: SaveProductMongo,
        val getProductsMongo: GetProductsMongo,
        val getProductByIdMongo: GetProductByIdMongo
) {

    @GetMapping
    fun products(): Flux<ProductModel> {
        return getProductsMongo.execute()
    }

    @GetMapping("/{id}")
    fun products(@PathVariable id: Long): Mono<ProductModel> {
        return getProductByIdMongo.execute(id)
    }

//    @PostMapping
//    fun save() {
//        productRepository
//                .save(Product(
//                        id = 123L,
//                        name = "Iphone 12",
//                        sku = "1",
//                        unitPrice = BigDecimal.valueOf(7000),
//                        thumbUrl = "http://wwww.google.com/imagemIphone12",
//                        itemType = "Eletrônico",
//                        active = true,
//                        allowedSaleToPerson = true,
//                        allowedSaleToCompany = true,
//                        installmentsMaxNumber = 12,
//                        createdAt = LocalDate.now(),
//                        updatedAt = LocalDate.now()
//                )).flux()
//    }

}