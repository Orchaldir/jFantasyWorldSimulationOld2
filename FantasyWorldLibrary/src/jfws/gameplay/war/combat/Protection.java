package jfws.gameplay.war.combat;

import jfws.gameplay.war.unit.stats.Stats;
import jfws.gameplay.war.unit.stats.value.Value;

public class Protection
{
	private String name_;
	private Value value_;
	
	public Protection(String name, Value value)
	{
		name_ = name;
		value_ = value;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public int getProtectionValue(Stats stats)
	{
		return value_.getValue(stats);
	}
}
