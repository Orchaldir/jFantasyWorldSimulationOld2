package jfws.gameplay.war.unit;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.Skill;
import jfws.gameplay.war.unit.type.UnitType;

public class Unit
{
	private String name_;
	private UnitType type_;
	
	public Unit(String name, UnitType type)
	{
		name_ = name;
		type_ = type;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public UnitType getType()
	{
		return type_;
	}
	
	public int getAttribute(Attribute attribute)
	{
		if(attribute == null)
			throw new IllegalArgumentException("Attribute can not be null!");
		
		return type_.getAttribute(attribute);
	}
	
	public int getSkill(Skill skill)
	{
		if(skill == null)
			throw new IllegalArgumentException("Skill can not be null!");
		
		return type_.getSkill(skill);
	}
}
