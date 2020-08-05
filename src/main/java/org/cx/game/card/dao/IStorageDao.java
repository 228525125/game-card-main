package org.cx.game.card.dao;

import org.cx.game.card.dao.domain.Storage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStorageDao extends MongoRepository<Storage, String> {
	
	public Storage findByAccount(String account);
}
