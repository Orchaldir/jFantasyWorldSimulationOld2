package jfws.gameplay.war.unit.stats;

import java.util.List;
import jfws.gameplay.war.combat.Protection;

public interface Stats
{
	int getAttribute(Attribute attribute);
	int getSkill(Skill skill);
	
	void getProtections(List<Protection> protections);
}
