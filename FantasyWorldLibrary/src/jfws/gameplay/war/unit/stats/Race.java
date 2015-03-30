package jfws.gameplay.war.unit.stats;

public class Race extends CharacterStats
{
	private String name_;
	
	public Race(String name)
	{
		name_ = name;
	}
	
	public String getName()
	{
		return name_;
	}
}
