package org.cx.game.card.dao.domain;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.level.LevelObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class Item extends LevelObject {
	
	private Integer price = 0;
	private Integer amount = 0;
}
