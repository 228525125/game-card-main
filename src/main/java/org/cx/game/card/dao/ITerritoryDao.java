package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.level.Territory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITerritoryDao extends MongoRepository<Territory, Long> {

}
