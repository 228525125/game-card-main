package org.cx.game.card.dao.domain.level.life;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cx.game.card.dao.domain.Deck;
import org.cx.game.card.dao.domain.level.Territory;
import org.cx.game.card.dao.domain.level.item.Item;
import org.cx.game.card.dao.domain.story.Story;
import org.cx.game.card.dao.domain.talent.Talent;
import org.cx.game.card.tools.TerritoryBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class Hero extends Life {

	private List<Deck> decks = new ArrayList<Deck>();
	private Map<Integer, Integer> cards = new HashMap<Integer, Integer>();
	private Integer defaultDeck = 0;
	private List<Item> items = new ArrayList<Item>();
	private Long selectedItem = 1050002l;
	private List<Story> stories = new ArrayList<Story>();
	private List<Talent> talents = new ArrayList<Talent>();
	private Integer skillPoint = 0;
	private Integer rank = 0;
}
