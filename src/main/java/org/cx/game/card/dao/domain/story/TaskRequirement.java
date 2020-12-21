package org.cx.game.card.dao.domain.story;

import java.util.List;

import lombok.Data;

@Data
public class TaskRequirement extends StoryRequirement {

	private List<Long> tasks;
}
