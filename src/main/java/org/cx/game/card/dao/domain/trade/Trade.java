package org.cx.game.card.dao.domain.trade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Trade {

	@Id
	private Long id;
	private Long pedlar;      //商贩
	private List<Commodity> commodities = new ArrayList<Commodity>();
}
