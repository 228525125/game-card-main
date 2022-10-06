package org.cx.game.card.dao.domain.level.building;

import lombok.Data;

@Data
public class NavigationBoard extends Building {

	private String range;
	private Integer tips = 0;
}
