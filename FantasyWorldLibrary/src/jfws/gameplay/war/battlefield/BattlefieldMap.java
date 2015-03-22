package jfws.gameplay.war.battlefield;

public class BattlefieldMap
{
	private int width_;
	private int height_;
	private BattlefieldCell cells_[][];
	
	public BattlefieldMap(int width, int height)
	{
		width_ = width;
		height_ = height;
		
		cells_ = new BattlefieldCell[height_][width_];
		
		for(int h = 0; h < height_; h++)
		{
			for(int w = 0; w < width_; w++)
			{
				cells_[h][w] = new BattlefieldCell();
			}
		}
	}
	
	public int getWidth()
	{
		return width_;
	}
	
	public int getHeight()
	{
		return height_;
	}
}
