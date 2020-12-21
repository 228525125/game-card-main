package org.cx.game.card.dao.domain.level;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.Life;

import lombok.Data;

@Data
public class Enemy extends Life {

	private Integer num;
	private Integer interval;
	
}
