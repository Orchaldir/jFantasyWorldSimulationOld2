package jfws.battle;

import jfws.gameplay.war.battlefield.*;

public class Battle
{
	
	public static void main(String[] args)
	{
		System.out.println("Battle Prototype");
		System.out.println("----------------\n");
		
		BattlefieldMap battlefield = new BattlefieldMap(5, 2);
		
		printBattlefield(battlefield);
	}
	
	public static void printBattlefield(BattlefieldMap battlefield)
	{
		for(int y = 0; y < battlefield.getSizeY(); y++)
		{
			String line = "";
			
			for(int x = 0; x < battlefield.getSizeX(); x++)
			{
				line += ".";
			}
			
			System.out.println(line);
		}
	}
	
}
