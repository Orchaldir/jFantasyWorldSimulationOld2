package jfws.gameplay.war.unit.stats.value;

import jfws.gameplay.war.unit.stats.Stats;

public class ConstantValue implements Value
{
	private int value_;
	
	public ConstantValue(int value)
	{
		value_ = value;
	}
	
	@Override
	public int getValue(Stats stats)
	{
		if(stats == null)
			throw new IllegalArgumentException("Stats can not be null!");
		
		return value_;
	}
}
