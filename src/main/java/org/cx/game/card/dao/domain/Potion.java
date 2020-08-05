package org.cx.game.card.dao.domain;

import org.cx.game.arithmetic.Point;

import lombok.Data;

@Data
public class Potion extends MapBuilder {

	private Integer value;
	private Point point;
	private String range;
}
