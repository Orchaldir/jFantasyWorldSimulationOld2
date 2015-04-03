package jfws.gameplay.war.unit.health;

public class HitPoints implements Health
{
	public static int DAMAGE_PER_HIT_POINT = 10;
	
	protected int max_count_;
	protected int hit_points_per_member_;
	protected int max_hit_points_;
	protected int hit_points_;
	
	public HitPoints(int count, int hit_points_per_member)
	{
		if(count <= 0)
			throw new IllegalArgumentException("Count must be greater 0!");
		else if(hit_points_per_member <= 0)
			throw new IllegalArgumentException("Hit Points must be greater 0!");
		
		max_count_ = count;
		hit_points_per_member_ = hit_points_per_member;
		max_hit_points_ = max_count_ * hit_points_per_member_;
		hit_points_ = max_hit_points_;
	}
	
	@Override
	public boolean isAlive()
	{
		return hit_points_ > 0;
	}
	
	@Override
	public boolean isDead()
	{
		return !isAlive();
	}
	
	@Override
	public int getCasualties()
	{
		return (max_hit_points_ - hit_points_) / hit_points_per_member_;
	}
	
	@Override
	public double getCasualtyFactor()
	{
		return getCasualties() / (double)max_count_;
	}
	
	@Override
	public int getMaxCount()
	{
		return max_count_;
	}
	
	@Override
	public int getCount()
	{
		return max_count_ - getCasualties();
	}
	
	public static double getHitPointsPerAttack(int damage_per_attack)
	{
		double factor = 0.5 + damage_per_attack / (double)DAMAGE_PER_HIT_POINT;
		
		return Math.max(factor, 0.0);
	}
	
	public static int getTotalDamage(int damage_per_attack, int N_attacks)
	{
		double damage = getHitPointsPerAttack(damage_per_attack) * N_attacks;
		
		return (int)Math.round(damage);
	}
	
	@Override
	public void applyDamage(int damage_per_attack, int N_attacks)
	{
		int damage = getTotalDamage(damage_per_attack, N_attacks);
		
		if(damage > hit_points_)
		{
			hit_points_ = 0;
		}
		else
		{
			hit_points_ -= damage;
		}
	}
}
