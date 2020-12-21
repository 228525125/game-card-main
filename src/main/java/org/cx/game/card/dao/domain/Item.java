package org.cx.game.card.dao.domain;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.level.MapBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Item extends MapBuilder {
	
	@Id
	private Long id;
	private String name;
	private Integer price;
	private Integer amount = 1;
	private Point point;
}
