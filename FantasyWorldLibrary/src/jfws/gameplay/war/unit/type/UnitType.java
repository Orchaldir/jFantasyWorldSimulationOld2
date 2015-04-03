package jfws.gameplay.war.unit.type;

import jfws.gameplay.war.unit.stats.Stats;

public abstract class UnitType implements Stats
{
	protected String name_;
	
	public UnitType(String name)
	{
		name_ = name;
	}
	
	public String getName()
	{
		return name_;
	}
	
	public int getHitPoints()
	{
		return 1;
	}
}
