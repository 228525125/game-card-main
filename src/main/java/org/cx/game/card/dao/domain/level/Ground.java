package org.cx.game.card.dao.domain.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cx.game.arithmetic.Point;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Ground {

	@Id
	private Long id;
	private Integer xborder = 9;                                       //边界x轴长度
	private Integer yborder = 6;                                       //边界y轴长度
	private List<Point> disables = new ArrayList<Point>();
	private List<LevelObject> builders = new ArrayList<LevelObject>();  //构建地图时的对象，与实际LevelObject不同
	private Map<Integer, LevelObject> LevelObjects = new HashMap<Integer, LevelObject>();   //当前Ground下的所有LevelObject
	private Map<String, Place> pointToPlace = new HashMap<String, Place>();
	private Point selectedPoint;
	private List<Point> selectedPaths = new ArrayList<Point>();
}
