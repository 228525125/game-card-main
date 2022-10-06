package org.cx.game.card.dao.domain.talent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PreTalentRequirement extends TalentRequirement {

	private List<Integer> talents = new ArrayList<Integer>();
}
