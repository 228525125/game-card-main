package org.cx.game.card.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoProperties {

	private String database;
    private String host;
    private Integer port;
    private String username;
    private String password;
    private String authenticationDatabase;
    private Integer minConnectionsPerHost;
    private Integer connectionsPerHost = 100;
}
