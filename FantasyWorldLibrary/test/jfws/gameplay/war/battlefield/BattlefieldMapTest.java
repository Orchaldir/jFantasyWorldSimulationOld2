package jfws.gameplay.war.battlefield;

import org.junit.Test;
import static org.junit.Assert.*;

public class BattlefieldMapTest
{
	private static int size_x = 2;
	private static int size_y_ = 3;
	private static BattlefieldMap battlefield_ = new BattlefieldMap(size_x, size_y_);

	@Test
	public void testGetWidth()
	{
		assertEquals(size_x, battlefield_.getSizeX());
	}

	@Test
	public void testGetHeight()
	{
		assertEquals(size_y_, battlefield_.getSizeY());
	}
	
	@Test
	public void testIsInsideIsTrue()
	{
		for(int y = 0; y < size_y_; y++)
		{
			for(int x = 0; x < size_x; x++)
			{
				assertTrue(battlefield_.isInside(x, y));
			}
		}
	}
	
	@Test
	public void testIsInsideIsFalse()
	{
		assertFalse(battlefield_.isInside(-1, 0));
		assertFalse(battlefield_.isInside(0, -1));
		assertFalse(battlefield_.isInside(size_x, 0));
		assertFalse(battlefield_.isInside(0, size_y_));
	}
	
	@Test
	public void testGetCell()
	{
		for(int y = 0; y < size_y_; y++)
		{
			for(int x = 0; x < size_x; x++)
			{
				assertNotNull(battlefield_.getCell(x, y));
			}
		}
	}
	
	@Test
	public void testGetCellOutsideMap()
	{
		assertNull(battlefield_.getCell(-1, 0));
		assertNull(battlefield_.getCell(0, -1));
		assertNull(battlefield_.getCell(size_x, 0));
		assertNull(battlefield_.getCell(0, size_y_));
	}
}