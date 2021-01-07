package org.cx.game.card.dao;

import java.util.List;

import org.cx.game.card.dao.domain.Storage;
import org.cx.game.card.dao.domain.story.Story;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStoryDao extends MongoRepository<Story, Long> {

	public List<Story> findAllByType(Integer type);
}
