package org.cx.game.card.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.cx.game.builder.ObjectTypeBuilder;
import org.cx.game.builder.ObjectTypeParse;
import org.cx.game.builder.exception.BuilderException;
import org.cx.game.builder.exception.ParseException;
import org.cx.game.card.dao.domain.level.Level;
import org.cx.game.card.service.Builder;
import org.cx.game.tools.IXmlHelper;
import org.cx.game.tools.XmlUtil;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LevelBuilder extends Builder<Level> {

	@Autowired
	public void setXmlHelper(IXmlHelper xh) {
		// TODO Auto-generated method stub
		this.xh = xh; 
	}
	
	public static void main(String[] args) {
		LevelBuilder builder = new LevelBuilder();
		System.out.println(builder.getClassName());
	}
}
