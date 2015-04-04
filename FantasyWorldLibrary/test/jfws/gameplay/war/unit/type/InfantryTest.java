package jfws.gameplay.war.unit.type;

import java.util.ArrayList;
import java.util.List;
import jfws.gameplay.war.combat.Protection;
import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.CharacterClass;
import jfws.gameplay.war.unit.stats.Race;
import jfws.gameplay.war.unit.stats.Skill;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class InfantryTest
{
	private String name_ = "Test Infantry";
	private static CharacterClass character_class_0_;
	private static CharacterClass character_class_1_;
	private static Race race_0_;
	private static Race race_1_;
	private static Attribute attribute_0_ = new Attribute("Attribute 0", 0);
	private static Attribute attribute_1_ = new Attribute("Attribute 1", 1);
	private static Skill skill_0_ = new Skill("Skill 0");
	private static Skill skill_1_ = new Skill("Skill 1");
	private static int attribute_level_0_ = 2;
	private static int attribute_level_1_ = 7;
	private static int skill_level_0_ = 3;
	private static int skill_level_1_ = 5;
	private static Protection protection_0_ = new Protection("Protection 0", null);
	private static Protection protection_1_ = new Protection("Protection 1", null);
	
	@BeforeClass
	public static void onlyOnce()
	{
		character_class_0_ = new CharacterClass("Character Class 0");
		character_class_0_.setAttribute(attribute_0_, attribute_level_0_);
		character_class_0_.setSkill(skill_0_, skill_level_0_);
		character_class_0_.addProtection(protection_0_);
		
		character_class_1_ = new CharacterClass("Character Class 1");
		character_class_1_.setAttribute(attribute_1_, attribute_level_1_);
		character_class_1_.setSkill(skill_1_, skill_level_1_);
		
		race_0_ = new Race("Race 0");
		race_0_.setAttribute(attribute_0_, attribute_level_1_);
		race_0_.setSkill(skill_0_, skill_level_1_);
		race_0_.addProtection(protection_1_);
		
		race_1_ = new Race("Race 1");
	}
	
	// CharacterClass
	
	@Test
	public void testGetCharacterClass()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		
		assertEquals(character_class_0_, infantry.getCharacterClass());
	}

	@Test
	public void testSetCharacterClass()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		
		infantry.setCharacterClass(character_class_1_);
		
		assertEquals(character_class_1_, infantry.getCharacterClass());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetCharacterClassWithNull()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		infantry.setCharacterClass(null);
	}
	
	// Race
	
	@Test
	public void testGetRace()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		
		assertEquals(race_0_, infantry.getRace());
	}

	@Test
	public void testSetRace()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		
		infantry.setRace(race_1_);
		
		assertEquals(race_1_, infantry.getRace());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetRaceWithNull()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		infantry.setRace(null);
	}
	
	// Attribute

	@Test
	public void testGetAttribute()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		
		int sum = attribute_level_0_ + attribute_level_1_;
		
		assertEquals(sum, infantry.getAttribute(attribute_0_));
		assertEquals(0, infantry.getAttribute(attribute_1_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAttributeWithNull()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		infantry.getAttribute(null);
	}
	
	// Skill

	@Test
	public void testGetSkill()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		
		int sum = skill_level_0_ + skill_level_1_;
		
		assertEquals(sum, infantry.getSkill(skill_0_));
		assertEquals(0, infantry.getSkill(skill_1_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSkillWithNull()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		infantry.getSkill(null);
	}
	
	// Protection
	
	@Test
	public void testGetProtections()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		List<Protection> protections = new ArrayList<>();
		
		infantry.getProtections(protections);
		
		assertEquals(2, protections.size());
		assertEquals(protection_0_, protections.get(0));
		assertEquals(protection_1_, protections.get(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetProtectionWithNull()
	{
		Infantry infantry = new Infantry(name_, character_class_0_, race_0_);
		infantry.getProtections(null);
	}
}