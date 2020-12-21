package org.cx.game.card.dao.domain;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.level.MapBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Building extends MapBuilder {

	@Id
	private Long id;
	private String name;
	private Point point;
}
