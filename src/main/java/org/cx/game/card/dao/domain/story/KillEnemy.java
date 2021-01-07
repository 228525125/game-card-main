package org.cx.game.card.dao.domain.story;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class KillEnemy extends StoryAction {

	private Map<Long, Integer> bom = new HashMap<Long, Integer>();
	private Map<Long, Integer> items = new HashMap<Long, Integer>();
}
