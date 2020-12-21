package org.cx.game.card.dao.domain.level;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.Building;
import org.cx.game.card.dao.domain.Item;
import org.cx.game.card.dao.domain.Life;

import lombok.Data;

@Data
public class Place {

	private Point point;
	private Building building;
	private Item item;
	private Life life;
	private Boolean disabled;
}
