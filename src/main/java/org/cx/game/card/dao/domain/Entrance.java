package org.cx.game.card.dao.domain;

import org.cx.game.arithmetic.Point;

import lombok.Data;

@Data
public class Entrance extends MapBuilder {

	private Point point;
	private String range;
}
