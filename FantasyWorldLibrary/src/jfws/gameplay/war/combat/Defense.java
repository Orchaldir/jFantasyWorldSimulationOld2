package jfws.gameplay.war.combat;

import jfws.gameplay.war.unit.stats.Stats;
import jfws.gameplay.war.unit.stats.value.Value;

public class Defense
{
	private String name_;
	private Value value_;
	
	public Defense(String name, Value value)
	{
		name_ = name;
		value_ = value;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public int getDefenseValue(Stats stats)
	{
		return value_.getValue(stats);
	}
}
