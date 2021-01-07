package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.trade.Trade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITradeDao extends MongoRepository<Trade, Long> {

}
