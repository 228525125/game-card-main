package org.cx.game.card.dao.domain;

import lombok.Data;

@Data
public class Enemy extends MapBuilder {

	public Integer num;
	public Integer interval;
	public String name;
}
