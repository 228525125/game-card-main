package org.cx.game.card.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Storage {

	@Id
	private Long id;
	
	private String account;
	
	private List<Deck> decks;
	
	public Deck getDefaultDeck() {
		for(Deck deck : decks) {
			if(deck.getSelected())
				return deck;
		}
		return null;
	}
}
