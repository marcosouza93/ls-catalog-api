package br.com.ls.catalog.api.usecases

import br.com.ls.catalog.api.entities.Product
import reactor.core.publisher.Mono

interface SaveProduct {
    fun execute(product: Mono<Product>): Mono<Product>
}