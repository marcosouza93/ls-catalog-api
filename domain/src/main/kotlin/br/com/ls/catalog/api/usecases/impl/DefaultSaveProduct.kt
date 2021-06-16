package br.com.ls.catalog.api.usecases.impl

import br.com.ls.catalog.api.entities.Product
import br.com.ls.catalog.api.usecases.SaveProduct
import reactor.core.publisher.Mono

class DefaultSaveProduct(): SaveProduct{
    override fun execute(product: Mono<Product>): Mono<Product> {
        TODO("Not yet implemented")
    }
}