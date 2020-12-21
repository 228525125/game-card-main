package org.cx.game.card.dao.domain.level;

import org.cx.game.card.dao.domain.Building;

import lombok.Data;

@Data
public class Exit extends Building {
	
	private String range;
}
