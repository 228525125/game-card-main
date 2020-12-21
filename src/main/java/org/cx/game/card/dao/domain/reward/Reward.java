package org.cx.game.card.dao.domain.reward;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Reward {

	@Id
	private Long id;
	private List<Formula> formulas;
	
}
