package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.level.item.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IItemDao extends MongoRepository<Item, Long> {

}
