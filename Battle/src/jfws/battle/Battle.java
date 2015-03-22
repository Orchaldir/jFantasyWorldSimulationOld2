package jfws.battle;

import jfws.gameplay.war.battlefield.*;
import jfws.gameplay.war.unit.Unit;

public class Battle
{
	
	public static void main(String[] args)
	{
		System.out.println("Battle Prototype");
		System.out.println("----------------\n");
		
		BattlefieldMap battlefield = new BattlefieldMap(5, 2);
		Unit unit = new Unit("HI1");
		
		battlefield.addUnit(unit, 2, 0);
		
		printBattlefield(battlefield, 3);
	}
	
	public static void printBattlefield(BattlefieldMap battlefield, int cell_size)
	{
		String border = "|";
		String free = " ";
		
		for(int y = 0; y < battlefield.getSizeY(); y++)
		{
			String line = border;
			
			for(int x = 0; x < battlefield.getSizeX(); x++)
			{
				Unit unit = battlefield.getCell(x, y).unit_;
				int start = 0;
				
				if(unit != null)
				{
					line += unit.getName();
					start = unit.getName().length();
				}
				
				for(;start < cell_size; start++)
				{
					line += free;
				}
				
				line += border;
			}
			
			System.out.println(line);
		}
	}
	
}
