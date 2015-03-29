package jfws.gameplay.war.unit.stats;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterClassTest
{
	private String name_ = "Test Class";
	
	@Test
	public void testGetName()
	{
		CharacterClass character_class = new CharacterClass(name_);
		assertEquals(name_, character_class.getName());
	}
}