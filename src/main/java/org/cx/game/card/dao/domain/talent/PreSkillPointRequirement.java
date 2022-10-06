package org.cx.game.card.dao.domain.talent;

import lombok.Data;

@Data
public class PreSkillPointRequirement extends TalentRequirement {

	private Integer level;
	private Integer amount;
}
