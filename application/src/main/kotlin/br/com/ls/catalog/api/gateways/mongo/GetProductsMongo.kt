package br.com.ls.catalog.api.gateways.mongo

import br.com.ls.catalog.api.entities.model.Product
import br.com.ls.catalog.api.gateways.mongo.repositories.ProductRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import br.com.ls.catalog.api.entities.database.Product.Companion as ProductDatabase

@Component
class GetProductsMongo(
        private val repository: ProductRepository
) {

    fun execute(): Flux<Product> {
        return repository.findAll().map(ProductDatabase::toModel)
    }
}