package org.cx.game.card.dao.domain.level;

import org.cx.game.arithmetic.Point;

import lombok.Data;

@Data
public class Place {

	private Point point;
	private Integer landform;
	private Integer building;
	private Integer item;
	private Integer life;
	private Boolean disabled;
}
