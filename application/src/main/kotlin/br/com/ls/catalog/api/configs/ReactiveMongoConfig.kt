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
//class ReactiveMongoConfig : AbstractReactiveMongoConfiguration() {
//
//    override fun getDatabaseName() = "live-shopping"
//
//    override fun reactiveMongoClient() = mongoClient()
//
//    @Bean
//    fun mongoClient() = MongoClients.create("mongodb+srv://app:FMwGXfVRS2RLgsu3Qsc9ty5q@cluster0.bmwsa.mongodb.net/podelive?retryWrites=true&w=majority")
//
//    @Bean
//    override fun reactiveMongoTemplate(databaseFactory: ReactiveMongoDatabaseFactory,
//                                       mongoConverter: MappingMongoConverter):
//            ReactiveMongoTemplate = ReactiveMongoTemplate(mongoClient(), databaseName)
//}