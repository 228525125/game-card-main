package org.cx.game.card.dao.domain;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Deck {

	private String name;
	private List<CardItem> cards;
	private Integer type = 0;
}
