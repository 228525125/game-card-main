package org.cx.game.card.service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.cx.game.builder.ObjectTypeBuilder;
import org.cx.game.builder.ObjectTypeParse;
import org.cx.game.builder.exception.BuilderException;
import org.cx.game.builder.exception.ParseException;
import org.cx.game.tools.IXmlHelper;
import org.cx.game.tools.XmlUtil;
import org.dom4j.Element;

/**
 * configure.properties 类名小写.path
 * xml <list><类名小写>...</类名小写></list>
 * @author admin
 *
 * @param <T>
 */
public abstract class Builder<T> {

	protected IXmlHelper xh;
	
	public abstract void setXmlHelper(IXmlHelper xh);
	
	public String getClassName() {
		Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return entityClass.getSimpleName().toLowerCase();
	}
	
	public String getPath() {
		// TODO Auto-generated method stub
		return getClassName()+".path";
	}
	
	public List<T> getInstances(){
		List<T> list = new ArrayList<T>();
		
		for(Element el : getElements()) {
			list.add(getInstance(el));
		}
		
		return list;
	}
	
	public List<Element> getElements(){
		List<Element> list = new ArrayList<Element>();
		Element root = xh.getRoot(getPath());
		
		for(Iterator it = root.elementIterator(getClassName());it.hasNext();){
			list.add((Element) it.next());
		}
		
		return list;
	}
	
	private T getInstance(Element el){
		ObjectTypeBuilder otb = new ObjectTypeBuilder();
		try {
			new ObjectTypeParse(otb).parse(el);
			T t = (T) otb.builder();			
			return t;
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
