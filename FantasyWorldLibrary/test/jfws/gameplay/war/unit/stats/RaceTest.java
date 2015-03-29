package jfws.gameplay.war.unit.stats;

import org.junit.Test;
import static org.junit.Assert.*;

public class RaceTest
{
	private String name_ = "Test Race";
	
	@Test
	public void testGetName()
	{
		Race race = new Race(name_);
		assertEquals(name_, race.getName());
	}
}