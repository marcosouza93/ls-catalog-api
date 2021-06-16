package br.com.ls.catalog.api.gateways.mongo

import br.com.ls.catalog.api.gateways.mongo.repositories.ProductRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class DeleteProductByIdMongo(
        private val repository: ProductRepository
) {

    fun execute(id: Long): Mono<Void> {
        return repository.deleteById(id)
    }
}