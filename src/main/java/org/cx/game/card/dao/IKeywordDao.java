package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.Keyword;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IKeywordDao extends MongoRepository<Keyword, Long> {

}
