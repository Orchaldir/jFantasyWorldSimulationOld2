package jfws.gameplay.war.unit.stats;

import java.util.ArrayList;
import java.util.List;
import jfws.gameplay.war.combat.Protection;
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
	private Protection protection_0_ = new Protection("Protection 0", null);
	private Protection protection_1_ = new Protection("Protection 1", null);
	
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
	public void testAddAndGetProtections()
	{
		CharacterStats stats = new CharacterStats();
		List<Protection> protections = new ArrayList<>();
		
		stats.addProtection(protection_0_);
		stats.getProtections(protections);
		
		assertEquals(1, protections.size());
		assertEquals(protection_0_, protections.get(0));
		
		stats.addProtection(protection_1_);
		protections.clear();
		stats.getProtections(protections);
		
		assertEquals(2, protections.size());
		assertEquals(protection_0_, protections.get(0));
		assertEquals(protection_1_, protections.get(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddProtectionWithNull()
	{
		CharacterStats stats = new CharacterStats();
		stats.addProtection(null);
	}
	
	@Test
	public void testGetEmptyProtections()
	{
		CharacterStats stats = new CharacterStats();
		List<Protection> protections = new ArrayList<>();
		
		stats.getProtections(protections);
		
		assertEquals(0, protections.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetProtectionWithNull()
	{
		CharacterStats stats = new CharacterStats();
		stats.getProtections(null);
	}
}