package org.cx.game.card.dao.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Storage {

	@Id
	private Long id;
	private String account;
	private String nickName = "Visitor";
	private List<Hero> heroes;
	private Long defaultHero = 1011001l;
	private Map<Integer, Integer> cards;
	private List<Item> items;
	private Long selectedItem = 1050002l;
	private List<String> npcList;
	private Integer defaultNPC = 0;
}
