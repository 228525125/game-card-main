package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IItemDao extends MongoRepository<Item, Long> {

}
