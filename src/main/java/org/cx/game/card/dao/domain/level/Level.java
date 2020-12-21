package org.cx.game.card.dao.domain.level;

import java.util.ArrayList;
import java.util.List;

import org.cx.game.arithmetic.Point;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Level {

	@Id
	private Long id;
	private String name;
	private Integer population;
	private List<Ground> grounds;
}
