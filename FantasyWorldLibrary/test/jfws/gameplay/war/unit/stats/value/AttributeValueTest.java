package jfws.gameplay.war.unit.stats.value;

import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.CharacterStats;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class AttributeValueTest
{
	private static CharacterStats stats_ = new CharacterStats();
	private static Attribute attribute_ = new Attribute("Attribute0", 0);
	private static int attribute_level_ = 9;
	private static int modifier_ = 1;
	private static AttributeValue value_ = new AttributeValue(attribute_, modifier_);
	
	@BeforeClass
	public static void setUpClass()
	{
		stats_.setAttribute(attribute_, attribute_level_);
	}
	
	@Test
	public void testGetValue()
	{
		assertEquals(attribute_level_ + modifier_, value_.getValue(stats_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetValueWithNull()
	{
		value_.getValue(null);
	}
}