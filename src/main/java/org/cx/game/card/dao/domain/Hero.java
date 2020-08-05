package org.cx.game.card.dao.domain;

import java.util.List;

import lombok.Data;

@Data
public class Hero {

	private String name;
	private List<Deck> decks;
	private Integer defaultDeck = 0;
	private Integer aiDeck = 0;
}
