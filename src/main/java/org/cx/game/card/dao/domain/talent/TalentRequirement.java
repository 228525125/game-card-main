package org.cx.game.card.dao.domain.talent;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import lombok.Data;

@Data
@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include = As.EXISTING_PROPERTY , property = "otype" ,visible = true)
public class TalentRequirement {

	private String otype;
	
	public String getOtype() {
		if(null == otype)
			return this.getClass().getName();
		else
			return otype;
	}
}
