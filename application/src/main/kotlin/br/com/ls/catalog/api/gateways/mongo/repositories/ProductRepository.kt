package br.com.ls.catalog.api.gateways.mongo.repositories

import br.com.ls.catalog.api.entities.database.Product
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : ReactiveMongoRepository<Product, Long>