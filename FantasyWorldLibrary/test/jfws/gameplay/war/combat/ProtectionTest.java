package jfws.gameplay.war.combat;

import jfws.gameplay.war.unit.stats.CharacterStats;
import jfws.gameplay.war.unit.stats.value.ConstantValue;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProtectionTest
{
	private CharacterStats stats_ = new CharacterStats();
	private int value_ = 9;
	private ConstantValue constant_ = new ConstantValue(value_);
	private String name_ = "Protection Name";
	private Protection protection_ = new Protection(name_, constant_);
	
	@Test
	public void testGetName()
	{
		assertEquals(name_, protection_.getName());
	}

	@Test
	public void testGetProtectionValue()
	{
		assertEquals(value_, protection_.getProtectionValue(stats_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetProtectionValueWithNull()
	{
		protection_.getProtectionValue(null);
	}
}