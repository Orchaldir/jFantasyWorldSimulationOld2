package jfws.gameplay.war.unit.stats;

import java.util.HashMap;
import java.util.Map;

public class CharacterClass
{
	private String name_;
	
	private Map<Attribute,Integer> attributes_ = new HashMap<>();
	private Map<Skill,Integer> skills_ = new HashMap<>();
	
	public CharacterClass(String name)
	{
		name_ = name;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public int getAttribute(Attribute attribute)
	{
		if(attribute == null)
			throw new IllegalArgumentException("Attribute can not be null!");
		else if(attributes_.containsKey(attribute))
			return attributes_.get(attribute);
		
		return 0;
	}
	
	public void setAttribute(Attribute attribute, int level)
	{
		if(attribute == null)
			throw new IllegalArgumentException("Attribute can not be null!");
		
		attributes_.put(attribute, level);
	}
	
	public int getSkill(Skill skill)
	{
		if(skill == null)
			throw new IllegalArgumentException("Skill can not be null!");
		else if(skills_.containsKey(skill))
			return skills_.get(skill);
		
		return 0;
	}
	
	public void setSkill(Skill skill, int level)
	{
		if(skill == null)
			throw new IllegalArgumentException("Skill can not be null!");
		
		skills_.put(skill, level);
	}
}