package org.cx.game.card.dao.domain;

import java.util.ArrayList;
import java.util.List;

import org.cx.game.card.dao.domain.level.Territory;
import org.cx.game.card.dao.domain.story.Story;
import org.cx.game.card.tools.TerritoryBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class Hero extends Life {

	private List<Deck> decks = new ArrayList<Deck>();
	private Integer defaultDeck = 0;
	private Integer aiDeck = 0;
	private List<Story> stories = new ArrayList<Story>();
	private List<Item> items = new ArrayList<Item>();
	private Long selectedItem = 1050002l;
	private List<Territory> territories = new ArrayList<Territory>();
	private Long selectedTerritory = 1070100l;
}
