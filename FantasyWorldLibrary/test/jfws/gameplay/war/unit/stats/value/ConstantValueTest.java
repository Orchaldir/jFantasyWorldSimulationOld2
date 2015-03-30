package jfws.gameplay.war.unit.stats.value;

import jfws.gameplay.war.unit.stats.CharacterStats;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConstantValueTest
{
	private CharacterStats stats_ = new CharacterStats();
	private int value_ = 9;
	
	@Test
	public void testGetValue()
	{
		ConstantValue value = new ConstantValue(value_);
		
		assertEquals(value_, value.getValue(stats_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetValueWithNull()
	{
		ConstantValue value = new ConstantValue(value_);
		
		value.getValue(null);
	}
}