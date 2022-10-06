package org.cx.game.card.dao.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.cx.game.card.dao.domain.level.Level;
import org.cx.game.card.dao.domain.level.Territory;
import org.cx.game.card.dao.domain.level.life.Hero;
import org.cx.game.card.dao.domain.story.Story;
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
	private List<Long> heroList;
	private Long defaultAi;
	private Map<Integer, Integer> cards;
	private List<Level> levels = new ArrayList<Level>();
	private Long defaultLevel;
	private List<Long> npcList;
	private Integer defaultNPC = 0;     //index
	private Integer genstone = 0;
}
