package org.cx.game.card.dao.domain.level.building;

import org.cx.game.arithmetic.Point;
import org.cx.game.card.dao.domain.level.LevelObject;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Data;

@Data
public class Building extends LevelObject {

	private Boolean discover = false;
}
