package org.cx.game.card.dao.domain.story;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class LookForItem extends StoryAction {

	private Map<Long, Integer> bom = new HashMap<Long, Integer>();
}
