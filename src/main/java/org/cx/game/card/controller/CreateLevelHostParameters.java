package org.cx.game.card.controller;

import org.cx.game.card.dao.domain.Storage;
import org.cx.game.card.dao.domain.level.Level;

import lombok.Data;

@Data
public class CreateLevelHostParameters {
	
	private String account;
	private Long levelId;
	
}
