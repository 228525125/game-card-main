package org.cx.game.card.dao.domain.level;

import org.cx.game.arithmetic.Point;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import lombok.Data;

@Data
@Document
@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS, include = As.EXISTING_PROPERTY , property = "otype" ,visible = true)
public class LevelObject {
	
	@Id
	private Long id;
	private String name;
	private Point point;
	private Integer sid = 0;
	private String otype;
	
	public String getOtype() {
		if(null == otype)
			return this.getClass().getName();
		else
			return otype;
	}
}
