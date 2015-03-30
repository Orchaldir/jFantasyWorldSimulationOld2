package jfws.gameplay.war.unit.stats.value;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.CharacterStats;
import jfws.gameplay.war.unit.stats.Skill;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class AttributeSkillComboTest
{
	private static CharacterStats stats_ = new CharacterStats();
	private static Attribute attribute_ = new Attribute("Attribute 0", 0);
	private static Skill skill_ = new Skill("Skill 0");
	private static int attribute_level_ = 3;
	private static int skill_level_ = 2;
	private static int modifier_ = 1;
	private static AttributeSkillCombo value_ = new AttributeSkillCombo(attribute_, skill_, modifier_);
	
	@BeforeClass
	public static void setUpClass()
	{
		stats_.setAttribute(attribute_, attribute_level_);
		stats_.setSkill(skill_, skill_level_);
	}
	
	@Test
	public void testGetValue()
	{
		int result = attribute_level_ + skill_level_ + modifier_;
		
		assertEquals(result, value_.getValue(stats_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetValueWithNull()
	{
		value_.getValue(null);
	}
}