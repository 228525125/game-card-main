package org.cx.game.card.controller;

import org.cx.game.card.dao.domain.Level;
import org.cx.game.card.dao.domain.Storage;

import lombok.Data;

@Data
public class CreateLevelHostParameters {
	
	private String account;
	private Long levelId;
	
}
