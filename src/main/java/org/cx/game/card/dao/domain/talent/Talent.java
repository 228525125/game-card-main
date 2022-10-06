package org.cx.game.card.dao.domain.talent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import lombok.Data;

@Data
@Document
@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include = As.EXISTING_PROPERTY , property = "otype" ,visible = true)
public class Talent {

	@Id
	private Long id;
	private String name;
	private String description;
	//private Integer talentType;
	//private Integer location;
	//private Integer level;
	private List<TalentRequirement> requirements = new ArrayList<TalentRequirement>();
	//private Integer consume = 1;
	//private Integer skillPoint = 0;
	//private Integer skillPointLimit = 1;
	private Integer grade = 0;
	
	private String otype;
	
	public String getOtype() {
		if(null == otype)
			return this.getClass().getName();
		else
			return otype;
	}
}
