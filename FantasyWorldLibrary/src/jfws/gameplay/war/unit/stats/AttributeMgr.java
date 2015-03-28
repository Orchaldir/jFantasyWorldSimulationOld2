package jfws.gameplay.war.unit.stats;

import java.util.HashMap;
import java.util.Map;

public class AttributeMgr
{
	private Map<String,Attribute> attributes_ = new HashMap<>();
	
	public int getNumberOfAttributes()
	{
		return attributes_.size();
	}
	
	public Attribute createAttribute(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name can not be null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name can not be empty!");
		else if(attributes_.containsKey(name))
			throw new IllegalArgumentException("Attribute \"" + name + "\" already exists!");
		
		Attribute new_attribute = new Attribute(name, getNumberOfAttributes());
		
		attributes_.put(name, new_attribute);
		
		return new_attribute;
	}
	
	public Attribute getAttribute(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name can not be null!");
		else if(name.isEmpty())
			throw new IllegalArgumentException("Name can not be empty!");
		
		return attributes_.get(name);
	}
}
