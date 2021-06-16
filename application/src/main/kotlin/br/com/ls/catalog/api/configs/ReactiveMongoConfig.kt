//package br.com.ls.catalog.api.configs
//
//import com.mongodb.reactivestreams.client.MongoClients
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
//
//@Configuration
//@EnableReactiveMongoRepositories
//class ReactiveMongoConfig: AbstractReactiveMongoConfiguration() {
//
//    override fun getDatabaseName() = "mongoDatabase"
//
//    override fun reactiveMongoClient() = mongoClient()
//
//    @Bean
//    fun mongoClient() = MongoClients.create()
//
//    @Bean
//    override fun reactiveMongoTemplate(databaseFactory: ReactiveMongoDatabaseFactory,
//                                       mongoConverter: MappingMongoConverter): ReactiveMongoTemplate
//    = ReactiveMongoTemplate(mongoClient(), databaseName)
//}