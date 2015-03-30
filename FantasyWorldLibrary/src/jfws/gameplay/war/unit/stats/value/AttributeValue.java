package jfws.gameplay.war.unit.stats.value;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.Stats;

public class AttributeValue implements Value
{
	private Attribute attribute_;
	private int modifier_;
	
	public AttributeValue(Attribute attribute, int modifier)
	{
		if(attribute == null)
			throw new IllegalArgumentException("Attribute can not be null!");
		
		attribute_ = attribute;
		modifier_ = modifier;
	}
	
	public AttributeValue(Attribute attribute)
	{
		this(attribute, 0);
	}
	
	@Override
	public int getValue(Stats stats)
	{
		if(stats == null)
			throw new IllegalArgumentException("Stats can not be null!");
		
		int attribute_level = stats.getAttribute(attribute_);
		
		return attribute_level + modifier_;
	}
}
