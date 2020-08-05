package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.LandformEffect;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ILandformEffectDao extends MongoRepository<LandformEffect, Long> {

}
