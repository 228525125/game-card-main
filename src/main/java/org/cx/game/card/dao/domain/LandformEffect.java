package org.cx.game.card.dao.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class LandformEffect {

	@Id
	private Long id;
	private Map<Integer, String> effects;
}
