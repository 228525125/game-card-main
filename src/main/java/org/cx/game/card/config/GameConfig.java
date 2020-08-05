package org.cx.game.card.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "game.card")
public class GameConfig {
	
	private Integer operatorInterval;
	private Integer matchTimeout;
	private Integer minDeckSize;
	private Integer maxDeckSize;
}
