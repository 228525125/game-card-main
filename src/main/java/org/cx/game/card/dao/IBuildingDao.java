package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.level.building.Building;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBuildingDao extends MongoRepository<Building, Long> {

}
