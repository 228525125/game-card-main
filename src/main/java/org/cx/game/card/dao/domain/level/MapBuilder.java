package org.cx.game.card.dao.domain.level;

import lombok.Data;

@Data
public abstract class MapBuilder implements IMapBuilder {
	
	public String getOtype() {
		return this.getClass().getName();
	}
}
