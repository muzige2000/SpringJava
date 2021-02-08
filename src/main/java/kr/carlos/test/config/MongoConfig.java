package kr.carlos.test.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
////package kr.carlos.test.config;
////
//import com.mongodb.MongoClientSettings;
//import com.mongodb.ServerAddress;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Collections;
////
//@Configuration
//public class MongoConfig {
//    private static final String host = "localhost";
//    private static final int port = 27017;
//    private static final String database = "blogapp";
//
//    @Bean
//    public MongoDatabase blogAppDatabase() {
//        MongoClient client = MongoClients.create(
//                MongoClientSettings.builder()
//                        .applyToClusterSettings(builder ->
//                                builder.hosts(Collections.singletonList(new ServerAddress(host, port))))
//                        .build());
//        return client.getDatabase((database));
//    }
//}
////@Configuration
////public class MongoConfig {
////
////    @Autowired
////    private Environment env;
////
//////    @Bean
//////    public MongoDbFactory mongoDbFactory() {
//////        return new SimpleMongoDbFactory(new MongoClientURI(env.getProperty("spring.data.mongodb.uri")));
//////    }
////
////    @Bean
////    public MongoTemplate mongoTemplate() {
////        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
////
////        return mongoTemplate;
////
////    }
////
////}

//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MongoConfig {
//
//    /*
//     * Use the standard Mongo driver API to create a com.mongodb.client.MongoClient instance.
//     */
//    public @Bean
//    MongoClient mongoClient() {
//        return MongoClients.create("mongodb://localhost:27017");
//    }
//}