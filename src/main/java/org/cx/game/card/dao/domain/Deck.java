package org.cx.game.card.dao.domain;

import java.util.Map;

import lombok.Data;

@Data
public class Deck {

	private String name;
	private Map<Integer, Integer> cards;
}
