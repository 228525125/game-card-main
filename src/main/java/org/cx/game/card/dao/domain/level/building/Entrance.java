package org.cx.game.card.dao.domain.level.building;

import org.cx.game.arithmetic.Point;

import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;

@Data
@JsonTypeName(value="org.cx.game.card.dao.domain.level.Entrance")
public class Entrance extends Building {

	private String range;
}
