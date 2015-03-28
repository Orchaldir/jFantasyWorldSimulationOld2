package jfws.battle;

import java.util.Scanner;
import jfws.gameplay.war.battlefield.*;
import jfws.gameplay.war.unit.Unit;
import jfws.gameplay.war.unit.stats.Attribute;
import jfws.gameplay.war.unit.stats.AttributeMgr;
import jfws.gameplay.war.unit.stats.CharacterClass;
import jfws.gameplay.war.unit.stats.Skill;
import jfws.gameplay.war.unit.stats.SkillMgr;

public class Battle
{
	public static Scanner input_ = new Scanner(System.in);
	
	public static AttributeMgr attribute_mgr_ = new AttributeMgr();
	public static SkillMgr skill_mgr_ = new SkillMgr();
	
	public static BattlefieldMap battlefield_ = new BattlefieldMap(5, 2);
	public static int cell_size_ = 3;
	
	public static void main(String[] args)
	{
		System.out.println("Battle Prototype");
		System.out.println("----------------\n");
		
		Attribute agility = attribute_mgr_.createAttribute("Agility");
		Attribute perception = attribute_mgr_.createAttribute("Perception");
		Attribute strength = attribute_mgr_.createAttribute("Strength");
		
		Skill fighting = skill_mgr_.createSkill("Fighting");
		Skill shooting = skill_mgr_.createSkill("Shooting");
		
		CharacterClass heavy_infantry = new CharacterClass("Heavy Infantry");
		heavy_infantry.setAttribute(strength, 2);
		heavy_infantry.setSkill(fighting, 2);
		
		Unit unit = new Unit("HI1");
		
		battlefield_.addUnit(unit, 2, 0);
		
		printBattlefield(battlefield_, cell_size_);
		
		while(true)
		{
			processInput(unit);
			printBattlefield(battlefield_, cell_size_);
		}
	}
	
	public static void printBattlefield(BattlefieldMap battlefield, int cell_size)
	{
		String border = "|";
		String free = " ";
		
		for(int y = battlefield.getSizeY() - 1; y >= 0; y--)
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
	
	public static boolean processInput(Unit unit)
	{
		System.out.println("");
		System.out.print(unit.getName() + "'s action: ");
		
		String command = input_.nextLine();
		String[] parts = command.split(" ");
		
		if(parts[0].equals("move"))
		{
			return processMove(unit, parts);
		}
		
		System.err.println("Unknown command!");
		
		return false;
	}
	
	public static boolean processMove(Unit unit, String[] parts)
	{
		if(parts.length != 2)
		{
			System.err.println("Move command is invalid!");
			return false;
		}

		String dir_name_ = parts[1];
		Direction dir;

		switch(dir_name_)
		{
			case "north":
				dir = Direction.NORTH;
				break;
			case "east":
				dir = Direction.EAST;
				break;
			case "south":
				dir = Direction.SOUTH;
				break;
			case "west":
				dir = Direction.WEST;
				break;
			default:
				System.err.println("Invalid Direction!");
				return false;
		}

		if(!battlefield_.moveUnit(unit, dir))
		{
			System.err.println("Could not move!");
			return false;
		}

		return true;
	}
}
