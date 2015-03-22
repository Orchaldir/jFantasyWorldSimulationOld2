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
		for(int h = 0; h < battlefield.getHeight(); h++)
		{
			String line = "";
			
			for(int w = 0; w < battlefield.getWidth(); w++)
			{
				line += ".";
			}
			
			System.out.println(line);
		}
	}
	
}
