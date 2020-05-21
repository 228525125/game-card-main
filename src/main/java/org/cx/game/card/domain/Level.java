package org.cx.game.card.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Level {

	@Id
	private Long id;
	
	private String name;
}
