package org.cx.game.card.dao.domain.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.Deck;
import org.cx.game.card.dao.domain.level.life.Hero;
import org.cx.game.tools.Util;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Level {

	@Id
	private Long id;
	private String name;
	private String description;
	private Integer population = 1;
	private List<Ground> grounds = new ArrayList<Ground>();
	private Integer selectedTeleporter = 0;
	private List<Hero> heroes = new ArrayList<Hero>();
	private Long defaultHero = 0l;
	private Integer selectedGround = 0;
}
