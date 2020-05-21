package org.cx.game.card.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.cx.game.builder.ObjectTypeBuilder;
import org.cx.game.builder.ObjectTypeParse;
import org.cx.game.builder.exception.BuilderException;
import org.cx.game.builder.exception.ParseException;
import org.cx.game.card.domain.Storage;
import org.cx.game.tools.IXmlHelper;
import org.cx.game.tools.XmlUtil;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StorageBuilder {

	@Autowired
	private IXmlHelper xh;
	
	public List<Storage> getInstances(){
		List<Storage> list = new ArrayList<Storage>();
		
		for(Element el : getElements()) {
			list.add(getInstance(el));
		}
		
		return list;
	}
	
	public List<Element> getElements(){
		List<Element> list = new ArrayList<Element>();
		Element root = xh.getRoot("storage.path");
		
		for(Iterator it = root.elementIterator(XmlUtil.Storage_Storage);it.hasNext();){
			list.add((Element) it.next());
		}
		
		return list;
	}
	
	private Storage getInstance(Element el){
		ObjectTypeBuilder otb = new ObjectTypeBuilder();
		try {
			new ObjectTypeParse(otb).parse(el);
			Storage storage = (Storage) otb.builder();			
			return storage;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
