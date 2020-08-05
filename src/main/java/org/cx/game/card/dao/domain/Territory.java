package org.cx.game.card.dao.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Territory {

	@Id
	private Long id;
	private String name;
	private List<Long> levels = new ArrayList<Long>();
	private List<Level> levelList = new ArrayList<Level>(); 
}
