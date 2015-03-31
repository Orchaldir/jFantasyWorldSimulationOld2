package jfws.gameplay.war.combat;

import jfws.gameplay.war.unit.stats.Stats;
import jfws.gameplay.war.unit.stats.value.Value;

public class Attack
{
	private String name_;
	private Value value_;
	private Value damage_;
	
	public Attack(String name, Value value, Value damage)
	{
		name_ = name;
		value_ = value;
		damage_ = damage;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public int getAttackValue(Stats stats)
	{
		return value_.getValue(stats);
	}
	
	public int getDamageValue(Stats stats)
	{
		return damage_.getValue(stats);
	}
}
