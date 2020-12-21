package org.cx.game.card.dao.domain.story;

import lombok.Data;

@Data
public abstract class StoryRequirement {

	public String getOtype() {
		return this.getClass().getName();
	}
}
