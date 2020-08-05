package org.cx.game.card.dao.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Message {

	@Id
	private Long id;
	private String language;
	private Map<String, String> message;
}
