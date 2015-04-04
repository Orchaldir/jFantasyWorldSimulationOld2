package jfws.gameplay.war.unit.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jfws.gameplay.war.combat.Protection;

public class CharacterStats implements Stats
{
	protected Map<Attribute,Integer> attributes_ = new HashMap<>();
	protected Map<Skill,Integer> skills_ = new HashMap<>();
	
	protected List<Protection> protections_ = new ArrayList<>();
	
	@Override
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
	
	@Override
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
	
	public void addProtection(Protection protection)
	{
		if(protection == null)
			throw new IllegalArgumentException("Protection can not be null!");
		
		protections_.add(protection);
	}
	
	@Override
	public void getProtections(List<Protection> protections)
	{
		if(protections == null)
			throw new IllegalArgumentException("List of Protections can not be null!");
		
		protections.addAll(protections_);
	}
}
