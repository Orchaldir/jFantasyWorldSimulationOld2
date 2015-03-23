package jfws.gameplay.war.battlefield;

import java.util.HashMap;
import java.util.Map;
import jfws.gameplay.war.unit.Unit;

public class BattlefieldMap
{
	private int size_x_;
	private int size_y_;
	private BattlefieldCell cells_[][];
	private Map<Unit,BattlefieldCell> units_ = new HashMap<>();
	
	public BattlefieldMap(int size_x, int size_y)
	{
		size_x_ = size_x;
		size_y_ = size_y;
		
		cells_ = new BattlefieldCell[size_y_][size_x_];
		
		for(int y = 0; y < size_y_; y++)
		{
			for(int x = 0; x < size_x_; x++)
			{
				cells_[y][x] = new BattlefieldCell(x, y);
			}
		}
	}
	
	public int getSizeX()
	{
		return size_x_;
	}
	
	public int getSizeY()
	{
		return size_y_;
	}
	
	public boolean isInside(int x, int y)
	{
		return x >= 0 && x < size_x_ && y >= 0 && y < size_y_;
	}
	
	public BattlefieldCell getCell(int x, int y)
	{
		if(!isInside(x, y))
		{
			return null;
		}
		
		return cells_[y][x];
	}
	
	public BattlefieldCell getNeighbor(BattlefieldCell cell, Direction dir)
	{
		if(cell == null)
		{
			throw new IllegalArgumentException("Cell cannot be null!");
		}
		
		int neighbor_x = cell.x_;
		int neighbor_y = cell.y_;
		
		if(dir == Direction.NORTH)
		{
			neighbor_y++;
		}
		else if(dir == Direction.EAST)
		{
			neighbor_x++;
		}
		else if(dir == Direction.SOUTH)
		{
			neighbor_y--;
		}
		else if(dir == Direction.WEST)
		{
			neighbor_x--;
		}
		
		return getCell(neighbor_x, neighbor_y);
	}
	
	public boolean addUnit(Unit unit, int x, int y)
	{
		if(unit == null)
		{
			throw new IllegalArgumentException("Unit cannot be null!");
		}
		else if(!isInside(x, y))
		{
			return false;
		}
		
		BattlefieldCell cell = cells_[y][x];
		
		if(cell.unit_ != null)
		{
			return false;
		}
		
		cell.unit_ = unit;
		units_.put(unit, cell);
		
		return true;
	}
	
	public boolean removeUnit(Unit unit)
	{
		if(unit == null)
		{
			throw new IllegalArgumentException("Unit cannot be null!");
		}
		
		BattlefieldCell cell = units_.remove(unit);
		
		if(cell == null)
		{
			return false;
		}
		
		cell.unit_ = null;
		
		return true;
	}
	
	public boolean moveUnit(Unit unit, Direction dir)
	{
		if(unit == null)
		{
			throw new IllegalArgumentException("Unit cannot be null!");
		}
		
		BattlefieldCell cell = units_.get(unit);
		
		if(cell == null)
		{
			return false;
		}
		
		BattlefieldCell neighbor = getNeighbor(cell, dir);
		
		if(neighbor == null)
		{
			return false;
		}
		else if(neighbor.unit_ != null)
		{
			return false;
		}
		
		neighbor.unit_ = unit;
		cell.unit_ = null;
		
		units_.put(unit, neighbor);
		
		return true;
	}
}
