package org.cx.game.card.dao.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Item {
	
	private Long id;
	private Integer amount;
}
