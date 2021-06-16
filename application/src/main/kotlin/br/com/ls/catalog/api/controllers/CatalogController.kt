package br.com.ls.catalog.api.controllers

import br.com.ls.catalog.api.gateways.mongo.DeleteProductByIdMongo
import br.com.ls.catalog.api.gateways.mongo.GetProductByIdMongo
import br.com.ls.catalog.api.gateways.mongo.GetProductsMongo
import br.com.ls.catalog.api.gateways.mongo.SaveProductMongo
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
        val getProductByIdMongo: GetProductByIdMongo,
        val deleteProductByIdMongo: DeleteProductByIdMongo
) {

    @GetMapping
    fun get(): Flux<ProductModel> {
        return getProductsMongo.execute()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Mono<ProductModel> {
        return getProductByIdMongo.execute(id)
    }

    @PostMapping
    fun save(@RequestBody product: Mono<ProductModel>): Mono<ProductModel> {
        return saveProductMongo.execute(product)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        deleteProductByIdMongo.execute(id)
    }

}