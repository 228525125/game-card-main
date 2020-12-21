package org.cx.game.card.dao.domain.reward;

import lombok.Data;

@Data
public abstract class Formula {

	public String getOtype() {
		return this.getClass().getName();
	}
}
