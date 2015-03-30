package jfws.gameplay.war.unit.stats.value;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.Stats;
import jfws.gameplay.war.unit.stats.Skill;

public class AttributeSkillCombo implements Value
{
	private Attribute attribute_;
	private Skill skill_;
	private int modifier_;
	
	public AttributeSkillCombo(Attribute attribute, Skill skill, int modifier)
	{
		if(attribute == null)
			throw new IllegalArgumentException("Attribute can not be null!");
		else if(skill == null)
			throw new IllegalArgumentException("Skill can not be null!");
		
		attribute_ = attribute;
		skill_ = skill;
		modifier_ = modifier;
	}
	
	public AttributeSkillCombo(Attribute attribute, Skill skill)
	{
		this(attribute, skill, 0);
	}
	
	@Override
	public int getValue(Stats stats)
	{
		if(stats == null)
			throw new IllegalArgumentException("Stats can not be null!");
		
		int attribute_level = stats.getAttribute(attribute_);
		int skill_level = stats.getSkill(skill_);
		
		return attribute_level + skill_level + modifier_;
	}
}
