package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.TagHelper;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITagHelperDao extends MongoRepository<TagHelper, Long> {

}
