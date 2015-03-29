package jfws.gameplay.war.unit.type;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.CharacterClass;
import jfws.gameplay.war.unit.stats.Skill;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class InfantryTest
{
	private String name_ = "Test Class";
	private static CharacterClass character_class_0_;
	private static CharacterClass character_class_1_;
	private static Attribute attribute_0_ = new Attribute("Attribute 0", 0);
	private static Attribute attribute_1_ = new Attribute("Attribute 1", 1);
	private static Skill skill_0_ = new Skill("Skill 0");
	private static Skill skill_1_ = new Skill("Skill 1");
	private static int attribute_level_0_ = 2;
	private static int attribute_level_1_ = 7;
	private static int skill_level_0_ = 3;
	private static int skill_level_1_ = 5;
	
	@BeforeClass
	public static void onlyOnce()
	{
		character_class_0_ = new CharacterClass("Character Class 0");
		character_class_0_.setAttribute(attribute_0_, attribute_level_0_);
		character_class_0_.setSkill(skill_0_, skill_level_0_);
		
		character_class_1_ = new CharacterClass("Character Class 1");
		character_class_1_.setAttribute(attribute_1_, attribute_level_1_);
		character_class_1_.setSkill(skill_1_, skill_level_1_);
	}
	
	// CharacterClass
	
	@Test
	public void testGetCharacterClass()
	{
		Infantry infantry = new Infantry(name_, character_class_0_);
		
		assertEquals(character_class_0_, infantry.getCharacterClass());
	}

	@Test
	public void testSetCharacterClass()
	{
		Infantry infantry = new Infantry(name_, character_class_0_);
		
		infantry.setCharacterClass(character_class_1_);
		
		assertEquals(character_class_1_, infantry.getCharacterClass());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetCharacterClassWithNull()
	{
		Infantry infantry = new Infantry(name_, character_class_0_);
		infantry.setCharacterClass(null);
	}
	
	// Attribute

	@Test
	public void testGetAttribute()
	{
		Infantry infantry = new Infantry(name_, character_class_0_);
		
		assertEquals(attribute_level_0_, infantry.getAttribute(attribute_0_));
		assertEquals(0, infantry.getAttribute(attribute_1_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAttributeWithNull()
	{
		Infantry infantry = new Infantry(name_, character_class_0_);
		infantry.getAttribute(null);
	}
	
	// Skill

	@Test
	public void testGetSkill()
	{
		Infantry infantry = new Infantry(name_, character_class_0_);
		
		assertEquals(skill_level_0_, infantry.getSkill(skill_0_));
		assertEquals(0, infantry.getSkill(skill_1_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSkillWithNull()
	{
		Infantry infantry = new Infantry(name_, character_class_0_);
		infantry.getSkill(null);
	}
}