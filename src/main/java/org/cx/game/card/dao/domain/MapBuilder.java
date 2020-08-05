package org.cx.game.card.dao.domain;

import lombok.Data;

@Data
public abstract class MapBuilder {

	private Long id;
	
	public String getOtype() {
		return this.getClass().getName();
	}
}
