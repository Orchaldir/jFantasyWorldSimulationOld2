package jfws.gameplay.war.unit.type;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.CharacterClass;
import jfws.gameplay.war.unit.stats.Skill;

public class Infantry extends UnitType
{
	protected CharacterClass character_class_;
	
	public Infantry(String name, CharacterClass character_class)
	{
		super(name);
		character_class_ = character_class;
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
	
	@Override
	public int getAttribute(Attribute attribute)
	{
		if(attribute == null)
			throw new IllegalArgumentException("Attribute can not be null!");
		
		return character_class_.getAttribute(attribute);
	}
	
	@Override
	public int getSkill(Skill skill)
	{
		if(skill == null)
			throw new IllegalArgumentException("Skill can not be null!");
		
		return character_class_.getSkill(skill);
	}
}
