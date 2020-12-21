package org.cx.game.card.dao.domain.story;

import lombok.Data;

@Data
public abstract class StoryAction {
	
	private Boolean actionnow = false;
	private StoryActionState state = StoryActionState.Doing;
	
	public String getOtype() {
		return this.getClass().getName();
	}
	
	public enum StoryActionState {
		Doing,
	    Ready,
	    Completed
	}
}
