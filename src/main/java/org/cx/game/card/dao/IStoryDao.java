package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.story.Story;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStoryDao extends MongoRepository<Story, Long> {

}
