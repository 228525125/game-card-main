package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMessageDao extends MongoRepository<Message, Long> {

}
