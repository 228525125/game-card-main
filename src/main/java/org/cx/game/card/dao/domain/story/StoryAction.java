package org.cx.game.card.dao.domain.story;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import lombok.Data;

@Data
@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include = As.EXISTING_PROPERTY , property = "otype" ,visible = true)
public class StoryAction {
	
	private String otype;
	private Boolean actionnow = false;
	private Integer state = 0;
	
	public String getOtype() {
		if(null == otype)
			return this.getClass().getName();
		else
			return otype;
	}
}
