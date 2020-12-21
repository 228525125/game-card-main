package org.cx.game.card.dao.domain.reward;

import lombok.Data;

@Data
public class ItemFormula extends Formula {

	private Long id;            //物品ID
	private String range;       //数量范围：1-1
	private Integer chance;     //基数是10000
}
