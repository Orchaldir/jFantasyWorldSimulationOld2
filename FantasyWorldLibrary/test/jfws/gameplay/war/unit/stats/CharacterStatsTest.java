package jfws.gameplay.war.unit.stats;

import jfws.gameplay.war.combat.Protection;
import jfws.gameplay.war.unit.stats.value.ConstantValue;
import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterStatsTest
{
	private Attribute attribute_0_ = new Attribute("Attribute 0", 0);
	private Attribute attribute_1_ = new Attribute("Attribute 1", 1);
	private Skill skill_0_ = new Skill("Skill 0");
	private Skill skill_1_ = new Skill("Skill 1");
	private int value_0_ = 2;
	private int value_1_ = 7;
	private int protection_value_0_ = 4;
	private int protection_value_1_ = 5;
	private Protection protection_0_ = new Protection("Protection 0", new ConstantValue(protection_value_0_));
	private Protection protection_1_ = new Protection("Protection 1", new ConstantValue(protection_value_1_));
	
	// Attribute

	@Test(expected=IllegalArgumentException.class)
	public void testGetAttributeWithNull()
	{
		CharacterStats stats = new CharacterStats();
		stats.getAttribute(null);
	}
	
	@Test
	public void testGetAttributeNotSet()
	{
		CharacterStats stats = new CharacterStats();
		
		assertEquals(0, stats.getAttribute(attribute_0_));
		assertEquals(0, stats.getAttribute(attribute_1_));
	}

	@Test
	public void testSetAndGetAttribute()
	{
		CharacterStats stats = new CharacterStats();
		
		stats.setAttribute(attribute_0_, value_0_);
		stats.setAttribute(attribute_1_, value_1_);
		
		assertEquals(value_0_, stats.getAttribute(attribute_0_));
		assertEquals(value_1_, stats.getAttribute(attribute_1_));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetAttributeWithNull()
	{
		CharacterStats stats = new CharacterStats();
		stats.setAttribute(null, value_0_);
	}
	
	// Skill
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSkillWithNull()
	{
		CharacterStats stats = new CharacterStats();
		stats.getSkill(null);
	}
	
	@Test
	public void testGetSkillNotSet()
	{
		CharacterStats stats = new CharacterStats();
		
		assertEquals(0, stats.getSkill(skill_0_));
		assertEquals(0, stats.getSkill(skill_1_));
	}

	@Test
	public void testSetAndGetSkill()
	{
		CharacterStats stats = new CharacterStats();
		
		stats.setSkill(skill_0_, value_0_);
		stats.setSkill(skill_1_, value_1_);
		
		assertEquals(value_0_, stats.getSkill(skill_0_));
		assertEquals(value_1_, stats.getSkill(skill_1_));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetSkillWithNull()
	{
		CharacterStats stats = new CharacterStats();
		stats.setSkill(null, value_0_);
	}
	
	// Protection
	
	@Test
	public void testGetProtection()
	{
		CharacterStats stats = new CharacterStats();
		stats.protection_ = protection_0_;
		
		assertEquals(protection_0_, stats.getProtection());
	}
	
	@Test
	public void testGetProtectionValue()
	{
		CharacterStats stats = new CharacterStats();
		stats.setProtection(protection_0_);
		
		assertEquals(protection_value_0_, stats.getProtectionValue(stats));
	}
	
	@Test
	public void testGetNoProtectionValue()
	{
		CharacterStats stats = new CharacterStats();
		assertEquals(0, stats.getProtectionValue(stats));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetProtectionValueWithNull()
	{
		CharacterStats stats = new CharacterStats();
		stats.getProtectionValue(null);
	}
	
	@Test
	public void testHasProtection()
	{
		CharacterStats stats = new CharacterStats();
		
		assertFalse(stats.hasProtection());
		
		stats.protection_ = protection_0_;
		
		assertTrue(stats.hasProtection());
	}
	
	@Test
	public void testSetProtection()
	{
		CharacterStats stats = new CharacterStats();
		stats.setProtection(protection_0_);
		
		assertEquals(protection_0_, stats.protection_);
	}
	
	@Test
	public void testSetProtectionWithNull()
	{
		CharacterStats stats = new CharacterStats();
		stats.protection_ = protection_0_;
		stats.setProtection(null);
		
		assertEquals(null, stats.protection_);
	}
}