package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.Preload;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPreloadDao extends MongoRepository<Preload, Long> {

}
