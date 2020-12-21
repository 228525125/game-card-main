package org.cx.game.card.dao.domain.story;

import java.util.Map;

import lombok.Data;

@Data
public class GainItem extends StoryAction {

	private Map<Integer, Integer> items;
}
