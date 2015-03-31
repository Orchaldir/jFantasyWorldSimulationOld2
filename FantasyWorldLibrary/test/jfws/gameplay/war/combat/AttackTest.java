package jfws.gameplay.war.combat;

import jfws.gameplay.war.unit.stats.CharacterStats;
import jfws.gameplay.war.unit.stats.value.ConstantValue;
import org.junit.Test;
import static org.junit.Assert.*;

public class AttackTest
{
	private CharacterStats stats_ = new CharacterStats();
	private int value_0_ = 2;
	private int value_1_ = 3;
	private ConstantValue constant_0_ = new ConstantValue(value_0_);
	private ConstantValue constant_1_ = new ConstantValue(value_1_);
	private String name_ = "Attack Name";
	private Attack attack_ = new Attack(name_, constant_0_, constant_1_);
	
	@Test
	public void testGetName()
	{
		assertEquals(name_, attack_.getName());
	}

	@Test
	public void testGetAttackValue()
	{
		assertEquals(value_0_, attack_.getAttackValue(stats_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAttackValueWithNull()
	{
		attack_.getAttackValue(null);
	}

	@Test
	public void testGetDamageValue()
	{
		assertEquals(value_1_, attack_.getDamageValue(stats_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetDamageValueWithNull()
	{
		attack_.getDamageValue(null);
	}
}