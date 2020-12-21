package org.cx.game.card.dao.domain;

import java.util.ArrayList;
import java.util.List;

import org.cx.game.card.dao.domain.story.Story;

import lombok.Data;

@Data
public class Hero {

	private Long id;
	private List<Deck> decks = new ArrayList<Deck>();
	private Integer defaultDeck = 0;
	private Integer aiDeck = 0;
	private List<Story> stories = new ArrayList<Story>();
	private List<Item> items = new ArrayList<Item>();
	private Long selectedItem = 1050002l;
}
