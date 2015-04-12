package jfws.gameplay.war.unit.type;

import java.util.List;
import jfws.gameplay.war.combat.Protection;
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
	
	public abstract void getProtections(List<Protection> protections);
}
