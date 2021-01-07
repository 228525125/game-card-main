package org.cx.game.card.dao.domain.level;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.Building;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@Data
@JsonTypeName(value="org.cx.game.card.dao.domain.level.Entrance")
public class Entrance extends Building {

	private String range;
}
