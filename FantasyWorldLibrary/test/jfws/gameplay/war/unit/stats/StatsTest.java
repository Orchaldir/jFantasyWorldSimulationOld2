package jfws.gameplay.war.unit.stats;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatsTest
{
	private Attribute attribute_0_ = new Attribute("Attribute 0", 0);
	private Attribute attribute_1_ = new Attribute("Attribute 1", 1);
	private Skill skill_0_ = new Skill("Skill 0");
	private Skill skill_1_ = new Skill("Skill 1");
	private int value_0_ = 2;
	private int value_1_ = 7;
	
	// Attribute

	@Test(expected=IllegalArgumentException.class)
	public void testGetAttributeWithNull()
	{
		Stats stats = new Stats();
		stats.getAttribute(null);
	}
	
	@Test
	public void testGetAttributeNotSet()
	{
		Stats stats = new Stats();
		
		assertEquals(0, stats.getAttribute(attribute_0_));
		assertEquals(0, stats.getAttribute(attribute_1_));
	}

	@Test
	public void testSetAndGetAttribute()
	{
		Stats stats = new Stats();
		
		stats.setAttribute(attribute_0_, value_0_);
		stats.setAttribute(attribute_1_, value_1_);
		
		assertEquals(value_0_, stats.getAttribute(attribute_0_));
		assertEquals(value_1_, stats.getAttribute(attribute_1_));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetAttributeWithNull()
	{
		Stats stats = new Stats();
		stats.setAttribute(null, value_0_);
	}
	
	// Skill
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSkillWithNull()
	{
		Stats stats = new Stats();
		stats.getSkill(null);
	}
	
	@Test
	public void testGetSkillNotSet()
	{
		Stats stats = new Stats();
		
		assertEquals(0, stats.getSkill(skill_0_));
		assertEquals(0, stats.getSkill(skill_1_));
	}

	@Test
	public void testSetAndGetSkill()
	{
		Stats stats = new Stats();
		
		stats.setSkill(skill_0_, value_0_);
		stats.setSkill(skill_1_, value_1_);
		
		assertEquals(value_0_, stats.getSkill(skill_0_));
		assertEquals(value_1_, stats.getSkill(skill_1_));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSetSkillWithNull()
	{
		Stats stats = new Stats();
		stats.setSkill(null, value_0_);
	}
}