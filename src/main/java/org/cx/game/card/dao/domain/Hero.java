package org.cx.game.card.dao.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Hero {

	private Long id;
	private List<Deck> decks = new ArrayList<Deck>();
	private Integer defaultDeck = 0;
	private Integer aiDeck = 0;
}
