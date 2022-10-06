package org.cx.game.card.dao.domain.level.item;

import lombok.Data;

@Data
public class Equipage extends Item {

	private Boolean wear = false;
	private Integer series = 0;
	private Integer triggerType = 1331;
}
