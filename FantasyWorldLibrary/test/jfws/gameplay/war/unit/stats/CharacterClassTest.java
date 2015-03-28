package jfws.gameplay.war.unit.stats;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterClassTest
{
	private String name_ = "Test Class";
	private Attribute attribute_0_ = new Attribute("Attribute 0", 0);
	private Attribute attribute_1_ = new Attribute("Attribute 1", 1);
	private Skill skill_0_ = new Skill("Skill 0");
	private Skill skill_1_ = new Skill("Skill 1");
	private int value_0_ = 2;
	private int value_1_ = 7;
	
	@Test
	public void testGetName()
	{
		CharacterClass character_class = new CharacterClass(name_);
		assertEquals(name_, character_class.getName());
	}
	
	// Attribute

	@Test(expected=IllegalArgumentException.class)
	public void testGetAttributeWithNull()
	{
		CharacterClass character_class = new CharacterClass(name_);
		character_class.getAttribute(null);
	}
	
	@Test
	public void testGetAttributeNotSet()
	{
		CharacterClass character_class = new CharacterClass(name_);
		
		assertEquals(0, character_class.getAttribute(attribute_0_));
		assertEquals(0, character_class.getAttribute(attribute_1_));
	}

	@Test
	public void testSetAndGetAttribute()
	{
		CharacterClass character_class = new CharacterClass(name_);
		
		character_class.setAttribute(attribute_0_, value_0_);
		character_class.setAttribute(attribute_1_, value_1_);
		
		assertEquals(value_0_, character_class.getAttribute(attribute_0_));
		assertEquals(value_1_, character_class.getAttribute(attribute_1_));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetAttributeWithNull()
	{
		CharacterClass character_class = new CharacterClass(name_);
		character_class.setAttribute(null, value_0_);
	}
	
	// Skill
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSkillWithNull()
	{
		CharacterClass character_class = new CharacterClass(name_);
		character_class.getSkill(null);
	}
	
	@Test
	public void testGetSkillNotSet()
	{
		CharacterClass character_class = new CharacterClass(name_);
		
		assertEquals(0, character_class.getSkill(skill_0_));
		assertEquals(0, character_class.getSkill(skill_1_));
	}

	@Test
	public void testSetAndGetSkill()
	{
		CharacterClass character_class = new CharacterClass(name_);
		
		character_class.setSkill(skill_0_, value_0_);
		character_class.setSkill(skill_1_, value_1_);
		
		assertEquals(value_0_, character_class.getSkill(skill_0_));
		assertEquals(value_1_, character_class.getSkill(skill_1_));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetSkillWithNull()
	{
		CharacterClass character_class = new CharacterClass(name_);
		character_class.setSkill(null, value_0_);
	}
}