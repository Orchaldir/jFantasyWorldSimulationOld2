package jfws.gameplay.war.unit.health;

import org.junit.Test;
import static org.junit.Assert.*;

public class HitPointsTest
{
	private int count_ = 10;
	private int hit_points_per_member_ = 2;
	private double delta_ = 0.001;
	
	@Test
	public void testIsAlive()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		for(int i = hp.max_hit_points_; i > 0; i--)
		{
			hp.hit_points_ = i;
			assertTrue(hp.isAlive());
		}
		
		hp.hit_points_ = 0;
		assertFalse(hp.isAlive());
	}

	@Test
	public void testIsDead()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		for(int i = hp.max_hit_points_; i > 0; i--)
		{
			hp.hit_points_ = i;
			assertFalse(hp.isDead());
		}
		
		hp.hit_points_ = 0;
		assertTrue(hp.isDead());
	}

	@Test
	public void testGetCasualties()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		for(int c = 0; c < count_; c++)
		{
			for(int p = 0; p < hit_points_per_member_; p++)
			{
				assertEquals(c, hp.getCasualties());
				hp.hit_points_--;
			}
		}
		
		assertEquals(count_, hp.getCasualties());
	}

	@Test
	public void testGetCasualtyFactor()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		for(int c = 0; c < count_; c++)
		{
			double factor = c / (double)count_;
			
			for(int p = 0; p < hit_points_per_member_; p++)
			{
				assertEquals(factor, hp.getCasualtyFactor(), delta_);
				hp.hit_points_--;
			}
		}
		
		assertEquals(1.0, hp.getCasualtyFactor(), delta_);
	}

	@Test
	public void testGetMaxCount()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		assertEquals(count_, hp.getMaxCount());
	}
	
	@Test
	public void testGetCount()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		for(int c = count_; c > 0; c--)
		{
			for(int p = 0; p < hit_points_per_member_; p++)
			{
				assertEquals(c, hp.getCount());
				hp.hit_points_--;
			}
		}
		
		assertEquals(0, hp.getCount());
	}
	
	@Test
	public void testGetHitPointsPerAttack()
	{
		int half = HitPoints.DAMAGE_PER_HIT_POINT / 2;
		double step = 1.0 / HitPoints.DAMAGE_PER_HIT_POINT;
		double value = 0.0;
		
		assertEquals(0.0, HitPoints.getHitPointsPerAttack(-(half+1)), delta_);
		
		for(int i = -half; i < HitPoints.DAMAGE_PER_HIT_POINT; i++)
		{
			assertEquals(value, HitPoints.getHitPointsPerAttack(i), delta_);
			value += step;
		}
	}
	
	@Test
	public void testGetTotalDamage()
	{
		int half = HitPoints.DAMAGE_PER_HIT_POINT / 2;
		int N = 100;
		int step = N / HitPoints.DAMAGE_PER_HIT_POINT;
		int value = 0;
		
		assertEquals(0, HitPoints.getTotalDamage(-(half+1), N));
		
		for(int i = -half; i < HitPoints.DAMAGE_PER_HIT_POINT; i++)
		{
			assertEquals(value, HitPoints.getTotalDamage(i, N));
			value += step;
		}
	}
	
	@Test
	public void testApplyDamage()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		hp.applyDamage(0, count_);
		
		assertEquals(hp.max_hit_points_ - count_ / 2, hp.hit_points_);
	}
	
	@Test
	public void testApplyMassiceDamage()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		hp.applyDamage(0, 1000);
		
		assertEquals(0, hp.hit_points_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testApplyNegativeNumberOfAttacks()
	{
		HitPoints hp = new HitPoints(count_, hit_points_per_member_);
		
		hp.applyDamage(0, -1);
	}
}