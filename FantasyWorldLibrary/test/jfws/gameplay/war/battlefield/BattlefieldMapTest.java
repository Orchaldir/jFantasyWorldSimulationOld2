package jfws.gameplay.war.battlefield;

import jfws.gameplay.war.unit.Unit;
import org.junit.Test;
import static org.junit.Assert.*;

public class BattlefieldMapTest
{
	private static int size_x = 2;
	private static int size_y_ = 3;
	private static BattlefieldMap battlefield_ = new BattlefieldMap(size_x, size_y_);
	private static Unit unit0_ = new Unit("0");
	private static Unit unit1_ = new Unit("1");

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
	
	@Test
	public void testGetNeighbor()
	{
		BattlefieldCell cell00 = battlefield_.getCell(0, 0);
		BattlefieldCell cell10 = battlefield_.getCell(1, 0);
		BattlefieldCell cell01 = battlefield_.getCell(0, 1);
		BattlefieldCell cell11 = battlefield_.getCell(1, 1);
		
		assertEquals(cell01, battlefield_.getNeighbor(cell00, Direction.NORTH));
		assertEquals(cell11, battlefield_.getNeighbor(cell01, Direction.EAST));
		assertEquals(cell10, battlefield_.getNeighbor(cell11, Direction.SOUTH));
		assertEquals(cell00, battlefield_.getNeighbor(cell10, Direction.WEST));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetNeighborWithNull()
	{
		battlefield_.getNeighbor(null, Direction.NORTH);
	}
	
	public void testGetNeighborOutsideMap()
	{
		BattlefieldCell cell00 = battlefield_.getCell(0, 0);
		BattlefieldCell cell11 = battlefield_.getCell(size_x-1, size_y_-1);
		
		assertNull(battlefield_.getNeighbor(cell11, Direction.NORTH));
		assertNull(battlefield_.getNeighbor(cell11, Direction.EAST));
		assertNull(battlefield_.getNeighbor(cell00, Direction.SOUTH));
		assertNull(battlefield_.getNeighbor(cell00, Direction.WEST));
	}
	
	@Test
	public void testAddUnit()
	{
		BattlefieldMap battlefield = new BattlefieldMap(size_x, size_y_);
		
		assertTrue(battlefield.addUnit(unit0_, 0, 0));
		assertEquals(unit0_, battlefield.getCell(0, 0).unit_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddUnitWithNull()
	{
		battlefield_.addUnit(null, 0, 0);
	}
	
	@Test
	public void testAddUnitOutsideMap()
	{
		assertFalse(battlefield_.addUnit(unit0_, -1, 0));
		assertFalse(battlefield_.addUnit(unit0_, 0, -1));
		assertFalse(battlefield_.addUnit(unit0_, size_x, 0));
		assertFalse(battlefield_.addUnit(unit0_, 0, size_y_));
	}
	
	@Test
	public void testAddUnitToFullCell()
	{
		BattlefieldMap battlefield = new BattlefieldMap(size_x, size_y_);
		
		assertTrue(battlefield.addUnit(unit0_, 0, 0));
		assertFalse(battlefield.addUnit(unit1_, 0, 0));
	}
	
	@Test
	public void testRemoveUnit()
	{
		BattlefieldMap battlefield = new BattlefieldMap(size_x, size_y_);
		
		battlefield.addUnit(unit0_, 0, 0);
		
		assertTrue(battlefield.removeUnit(unit0_));
		assertNull(battlefield.getCell(0, 0).unit_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveUnitWithNull()
	{
		battlefield_.removeUnit(null);
	}
	
	@Test
	public void testRemoveUnitNotAdded()
	{
		assertFalse(battlefield_.removeUnit(unit0_));
		assertFalse(battlefield_.removeUnit(unit1_));
	}
	
	@Test
	public void testMoveUnit()
	{
		BattlefieldMap battlefield = new BattlefieldMap(size_x, size_y_);
		
		battlefield.addUnit(unit0_, 0, 0);
		
		assertTrue(battlefield.moveUnit(unit0_, Direction.NORTH));
		assertEquals(unit0_, battlefield.getCell(0, 1).unit_);
		
		assertTrue(battlefield.moveUnit(unit0_, Direction.EAST));
		assertEquals(unit0_, battlefield.getCell(1, 1).unit_);
		
		assertTrue(battlefield.moveUnit(unit0_, Direction.SOUTH));
		assertEquals(unit0_, battlefield.getCell(1, 0).unit_);
		
		assertTrue(battlefield.moveUnit(unit0_, Direction.WEST));
		assertEquals(unit0_, battlefield.getCell(0, 0).unit_);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMoveUnitWithNull()
	{
		battlefield_.moveUnit(null, Direction.NORTH);
	}
	
	@Test
	public void testMoveUnitNotAdded()
	{
		assertFalse(battlefield_.moveUnit(unit0_, Direction.NORTH));
		assertFalse(battlefield_.moveUnit(unit0_, Direction.EAST));
		assertFalse(battlefield_.moveUnit(unit0_, Direction.SOUTH));
		assertFalse(battlefield_.moveUnit(unit0_, Direction.WEST));
	}
}