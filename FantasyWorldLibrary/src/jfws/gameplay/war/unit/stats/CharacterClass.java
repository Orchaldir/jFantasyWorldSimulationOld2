package jfws.gameplay.war.unit.stats;

public class CharacterClass extends Stats
{
	private String name_;
	
	public CharacterClass(String name)
	{
		name_ = name;
	}
	
	public String getName()
	{
		return name_;
	}
}
