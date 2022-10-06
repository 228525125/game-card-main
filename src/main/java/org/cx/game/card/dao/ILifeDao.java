package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.level.life.Life;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILifeDao extends MongoRepository<Life, Long> {

}
