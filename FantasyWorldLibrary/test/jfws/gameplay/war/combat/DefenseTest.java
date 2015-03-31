package jfws.gameplay.war.combat;

import jfws.gameplay.war.unit.stats.CharacterStats;
import jfws.gameplay.war.unit.stats.value.ConstantValue;
import org.junit.Test;
import static org.junit.Assert.*;

public class DefenseTest
{
	private CharacterStats stats_ = new CharacterStats();
	private int value_ = 9;
	private ConstantValue constant_ = new ConstantValue(value_);
	private String name_ = "Defense Name";
	private Defense defense_ = new Defense(name_, constant_);
	
	@Test
	public void testGetName()
	{
		assertEquals(name_, defense_.getName());
	}

	@Test
	public void testGetDefenseValue()
	{
		assertEquals(value_, defense_.getDefenseValue(stats_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetDefenseValueWithNull()
	{
		defense_.getDefenseValue(null);
	}
}