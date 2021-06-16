package br.com.ls.catalog.api.gateways.mongo

import br.com.ls.catalog.api.entities.model.Product
import br.com.ls.catalog.api.gateways.mongo.repositories.ProductRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import br.com.ls.catalog.api.entities.database.Product.Companion as ProductDatabase

@Component
class GetProductByIdMongo(
        private val repository: ProductRepository
) {

    fun execute(id: Long): Mono<Product> {
        return repository.findById(id).map(ProductDatabase::toModel)
    }
}