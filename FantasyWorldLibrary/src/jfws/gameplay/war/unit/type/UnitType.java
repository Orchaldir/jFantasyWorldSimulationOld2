package jfws.gameplay.war.unit.type;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.Skill;

public abstract class UnitType
{
	protected String name_;
	
	public UnitType(String name)
	{
		name_ = name;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public abstract int getAttribute(Attribute attribute);
	
	public abstract int getSkill(Skill skill);
}
