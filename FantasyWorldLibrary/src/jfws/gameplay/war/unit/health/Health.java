package jfws.gameplay.war.unit.health;

public interface Health
{
	boolean isAlive();
	boolean isDead();
	
	int getCasualties();
	double getCasualtyFactor();

	int getMaxCount();
	int getCount();
	
	void applyDamage(int damage, int N_attacks);
}
