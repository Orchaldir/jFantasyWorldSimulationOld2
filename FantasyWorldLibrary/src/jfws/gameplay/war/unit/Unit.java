package jfws.gameplay.war.unit;

import java.util.List;
import jfws.gameplay.war.combat.Protection;
import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.Skill;
import jfws.gameplay.war.unit.stats.Stats;
import jfws.gameplay.war.unit.type.UnitType;

public class Unit implements Stats
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
	
	@Override
	public int getAttribute(Attribute attribute)
	{
		if(attribute == null)
			throw new IllegalArgumentException("Attribute can not be null!");
		
		return type_.getAttribute(attribute);
	}
	
	@Override
	public int getSkill(Skill skill)
	{
		if(skill == null)
			throw new IllegalArgumentException("Skill can not be null!");
		
		return type_.getSkill(skill);
	}
	
	@Override
	public void getProtections(List<Protection> protections)
	{
		if(protections == null)
			throw new IllegalArgumentException("List of Protections can not be null!");
		
		type_.getProtections(protections);
	}
}
