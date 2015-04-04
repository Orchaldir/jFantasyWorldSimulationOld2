package jfws.gameplay.war.unit;

import java.util.ArrayList;
import java.util.List;
import jfws.gameplay.war.combat.Protection;
import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.Skill;
import jfws.gameplay.war.unit.type.Infantry;
import jfws.gameplay.war.unit.type.UnitType;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTest
{
	private int attribute_level_ = 2;
	private int skill_level_ = 3;
	private Protection protection_0_ = new Protection("Protection 0", null);
	
	public class MockUnitType extends UnitType
	{
		public MockUnitType(String name)
		{
			super(name);
		}

		@Override
		public int getAttribute(Attribute attribute)
		{
			return attribute_level_;
		}

		@Override
		public int getSkill(Skill skill)
		{
			return skill_level_;
		}
		
		@Override
		public void getProtections(List<Protection> protections)
		{
			protections.add(protection_0_);
		}
	}
	
	private String name_ = "Test Infantry";
	private static Attribute attribute_ = new Attribute("Attribute", 0);
	private static Skill skill_ = new Skill("Skill");
	private UnitType type_ = new MockUnitType("Mock Unit Type");
	private Unit unit_ = new Unit(name_, type_);
	
	@Test
	public void testGetName()
	{
		assertEquals(name_, unit_.getName());
	}

	@Test
	public void testGetType()
	{
		assertEquals(type_, unit_.getType());
	}
	
	// Attribute

	@Test
	public void testGetAttribute()
	{
		assertEquals(attribute_level_, unit_.getAttribute(attribute_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAttributeWithNull()
	{
		unit_.getAttribute(null);
	}
	
	// Skill

	@Test
	public void testGetSkill()
	{
		assertEquals(skill_level_, unit_.getSkill(skill_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSkillWithNull()
	{
		unit_.getSkill(null);
	}
	
	// Protection
	
	@Test
	public void testGetProtections()
	{
		List<Protection> protections = new ArrayList<>();
		
		unit_.getProtections(protections);
		
		assertEquals(1, protections.size());
		assertEquals(protection_0_, protections.get(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetProtectionsWithNull()
	{
		unit_.getProtections(null);
	}
}