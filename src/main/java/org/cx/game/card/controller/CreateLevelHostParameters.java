package org.cx.game.card.controller;

import org.cx.game.card.domain.Level;
import org.cx.game.card.domain.Storage;

import lombok.Data;

@Data
public class CreateLevelHostParameters {
	
	private Level level;
	private Storage storage;
	
}
