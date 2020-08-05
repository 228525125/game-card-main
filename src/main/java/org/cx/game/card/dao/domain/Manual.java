package org.cx.game.card.dao.domain;

import java.util.Map;

import lombok.Data;

@Data
public class Manual {

	private Long id;
	private Map<String, String> properties;
}
