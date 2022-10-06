package org.cx.game.card.tools;

import org.cx.game.card.dao.domain.talent.Talent;
import org.cx.game.card.service.Builder;
import org.cx.game.tools.IXmlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TalentBuilder extends Builder<Talent> {

	@Autowired
	public void setXmlHelper(IXmlHelper xh) {
		// TODO Auto-generated method stub
		this.xh = xh;
	}

}
