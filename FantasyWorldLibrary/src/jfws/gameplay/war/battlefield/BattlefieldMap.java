package jfws.gameplay.war.battlefield;

public class BattlefieldMap
{
	private int size_x_;
	private int size_y_;
	private BattlefieldCell cells_[][];
	
	public BattlefieldMap(int size_x, int size_y)
	{
		size_x_ = size_x;
		size_y_ = size_y;
		
		cells_ = new BattlefieldCell[size_y_][size_x_];
		
		for(int y = 0; y < size_y_; y++)
		{
			for(int x = 0; x < size_x_; x++)
			{
				cells_[y][x] = new BattlefieldCell();
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
}
