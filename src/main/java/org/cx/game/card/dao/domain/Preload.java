package org.cx.game.card.dao.domain;

import java.util.Map;

import lombok.Data;

@Data
public class Preload {

	private Long id;
	private Map<String, String> assets;
}
