package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.Manual;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IManualDao extends MongoRepository<Manual, Long> {

}
