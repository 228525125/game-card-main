package org.cx.game.card.dao.domain.level.building;

import lombok.Data;

@Data
public class Teleporter extends Building {

	private Integer type = 2;
	private String range;
	private Boolean startup = false;
}
