package jfws.gameplay.war.unit.stats;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SkillMgrTest
{
	static private String name_ = "Skill";
	static private SkillMgr skill_mgr_;
	
	@Before
	public void setUp()
	{
		skill_mgr_ = new SkillMgr();
	}

	@Test
	public void testCreateSkill()
	{
		Skill skill = skill_mgr_.createSkill(name_);
		
		assertNotNull(skill);
		assertEquals(name_, skill.getName());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateSkillWithNull()
	{
		skill_mgr_.createSkill(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateSkillWithEmptyString()
	{
		skill_mgr_.createSkill("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateSkillTwice()
	{
		skill_mgr_.createSkill(name_);
		skill_mgr_.createSkill(name_);
	}

	@Test
	public void testGetSkill()
	{
		Skill skill = skill_mgr_.createSkill(name_);
		
		assertEquals(skill, skill_mgr_.getSkill(name_));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSkillWithNull()
	{
		skill_mgr_.getSkill(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSkillWithEmptyString()
	{
		skill_mgr_.getSkill("");
	}
}