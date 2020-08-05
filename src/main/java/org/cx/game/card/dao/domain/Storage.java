package org.cx.game.card.dao.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Storage {

	@Id
	private Long id;
	private String account;
	private String nickName = "Visitor";
	private List<Hero> heroes;
	private Integer defaultHero = 0;
}
