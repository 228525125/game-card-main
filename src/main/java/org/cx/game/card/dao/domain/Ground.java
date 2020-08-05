package org.cx.game.card.dao.domain;

import java.util.List;

import org.cx.game.arithmetic.Point;

import lombok.Data;

@Data
public class Ground {

	private Integer xBorder = 0;                                       //边界x轴长度
	private Integer yBorder = 0;                                       //边界y轴长度
	private List<Point> disables;
	private List<MapBuilder> builders;
}
