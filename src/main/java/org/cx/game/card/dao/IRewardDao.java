package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.reward.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRewardDao extends MongoRepository<Reward, Long> {

}
