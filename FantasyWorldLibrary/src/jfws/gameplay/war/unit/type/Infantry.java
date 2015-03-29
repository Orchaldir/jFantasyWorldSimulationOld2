package jfws.gameplay.war.unit.type;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.CharacterClass;
import jfws.gameplay.war.unit.stats.Race;
import jfws.gameplay.war.unit.stats.Skill;

public class Infantry extends UnitType
{
	protected CharacterClass character_class_;
	protected Race race_;
	
	public Infantry(String name, CharacterClass character_class, Race race)
	{
		super(name);
		character_class_ = character_class;
		race_ = race;
	}
	
	public CharacterClass getCharacterClass()
	{
		return character_class_;
	}

	public void setCharacterClass(CharacterClass character_class)
	{
		if(character_class == null)
			throw new IllegalArgumentException("Character Class can not be null!");
		
		character_class_ = character_class;
	}
	
	public Race getRace()
	{
		return race_;
	}

	public void setRace(Race race)
	{
		if(race == null)
			throw new IllegalArgumentException("Race can not be null!");
		
		race_ = race;
	}
	
	@Override
	public int getAttribute(Attribute attribute)
	{
		if(attribute == null)
			throw new IllegalArgumentException("Attribute can not be null!");
		
		return character_class_.getAttribute(attribute) + race_.getAttribute(attribute);
	}
	
	@Override
	public int getSkill(Skill skill)
	{
		if(skill == null)
			throw new IllegalArgumentException("Skill can not be null!");
		
		return character_class_.getSkill(skill) + race_.getSkill(skill);
	}
}
