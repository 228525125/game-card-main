package org.cx.game.card.dao.domain.trade;

import org.cx.game.card.dao.domain.Item;

import lombok.Data;

@Data
public class Commodity {

	private Long debit;
	private Long credit;
	private Integer rate;      //以10000为基数，debit / credit * 10000 = rate
}
