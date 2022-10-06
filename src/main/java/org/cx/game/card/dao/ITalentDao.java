package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.talent.Talent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITalentDao extends MongoRepository<Talent, Long> {

}
