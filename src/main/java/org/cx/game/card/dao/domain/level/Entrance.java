package org.cx.game.card.dao.domain.level;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.Building;

import lombok.Data;

@Data
public class Entrance extends Building {

	private String range;
}
