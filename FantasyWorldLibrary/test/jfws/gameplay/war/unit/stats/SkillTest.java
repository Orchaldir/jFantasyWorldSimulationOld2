package jfws.gameplay.war.unit.stats;

import org.junit.Test;
import static org.junit.Assert.*;

public class SkillTest
{
	static private String name_ = "Skill";
	static private Skill skill_ = new Skill(name_);

	@Test
	public void testGetName()
	{
		assertEquals(name_, skill_.getName());
	}
}