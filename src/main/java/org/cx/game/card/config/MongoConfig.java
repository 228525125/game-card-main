package org.cx.game.card.config;

import javax.annotation.Resource;

import org.cx.game.card.dao.IDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories(basePackageClasses = {IDao.class})
public class MongoConfig {

	@Resource
	private MongoProperties mongoProperties;
	
	@Bean
    public MongoDbFactory mongoDbFactory() {
        // 配置连接池
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(mongoProperties.getConnectionsPerHost());
        builder.minConnectionsPerHost(mongoProperties.getMinConnectionsPerHost());
        MongoClientOptions mongoClientOptions = builder.build();
        // 配置MongoDB地址
        ServerAddress serverAddress = new ServerAddress(mongoProperties.getHost(), mongoProperties.getPort());
        // 配置连接认证
        MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(
                mongoProperties.getUsername(),
                mongoProperties.getAuthenticationDatabase() != null ? mongoProperties.getAuthenticationDatabase() : mongoProperties.getDatabase(),
                mongoProperties.getPassword().toCharArray()
        );
        // 创建客户端和Factory
        //MongoClient mongoClient = new MongoClient(serverAddress, mongoCredential, mongoClientOptions);
        MongoClient mongoClient = new MongoClient(serverAddress, mongoClientOptions);
        return new SimpleMongoDbFactory(mongoClient, mongoProperties.getDatabase());
    }
}
