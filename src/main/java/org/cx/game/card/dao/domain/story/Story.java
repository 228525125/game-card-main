package org.cx.game.card.dao.domain.story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Story {

	@Id
	private Long id;
	private String language = "zh_CN";
	private Integer type = 3;
	private String title = "挑战";
	private Long publisher = 0l;
	private List<StoryRequirement> requirements = new ArrayList<StoryRequirement>();
	private Map<Integer, Map<Integer, String>> content = new HashMap<Integer, Map<Integer, String>>();
	private Boolean completed = false;
	private Integer doing = 1;
	private Map<Integer, StoryAction> actions = new HashMap<Integer, StoryAction>();
}
