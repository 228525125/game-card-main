package org.cx.game.card.domain;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Deck {

	private String name;
	private Boolean selected;
	private Map<Integer, Integer> cards;
}
