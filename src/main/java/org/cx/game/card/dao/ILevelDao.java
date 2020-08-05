package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.Level;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILevelDao extends MongoRepository<Level, Long> {

}
