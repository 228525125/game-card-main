package org.cx.game.card.dao.domain.story;

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
	private String language;
	private String type;
	private String title;
	private Long publisher;
	private List<StoryRequirement> requirements;
	private Map<Integer, Map<Integer, String>> content;
	private Boolean completed = false;
	private Integer doing = 1;
	private Map<Integer, StoryAction> actions;
}
