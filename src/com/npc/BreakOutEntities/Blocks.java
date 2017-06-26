package com.npc.BreakOutEntities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.npc.BreakOutEngine.GameEngine;
import com.npc.BreakOutForm.PlayGame;


public class Blocks 
{
	public static ArrayList<Point> blocks;
	public static List<Integer> blockskWidth;
	public static List<Integer> blocksHeight;
	int width = 45;
	int height = 24;
	public int score2 = 0;
	
	public Blocks()
	{
		blockskWidth = new ArrayList<Integer>();
		blocksHeight = new ArrayList<Integer>();
		blocks = new ArrayList<Point>();
		//initBlocks();
		if(score2 == 0)
		{
			initBlocks();
		}
		else if(PlayGame.highscore == 114)
		{
			Blocks1();
		}
		else if(score2 == 304)
		{
			NextLevel3();
		}
	}
	public void Component(Graphics g)
	{
		g.drawString("Goodjob you finish the game :D" , 20 , 650);
		g.setColor(Color.BLACK);
	}
	public void Blocks1()
	{
		for(int i =0; i < 148; i++)
		{
			blockskWidth.add(width);
			blocksHeight.add(height);
			blocks.add(new Point(-33,-33));
		}
		int y=0;
		int x = 0;
		int count=0;
		for(int i = 27 ; i < blocks.size();i++) 
		//for(int i = 0 ;i< blocks.size();i++)
		{
			blocks.get(i).setLocation(40+(width*x), 40+height*y);
			x++;
			count++;
			if(count == 11)
			{
				count=0;
				x=0;
				y++;
			}
		}
	}
	public void initBlocks()
	{
		for(int i = 0; i < 71;i++) //number of blocks 
			//	for(int i = 0; i < 250;i++)
				{
					blockskWidth.add(width);
					blocksHeight.add(height);
					blocks.add(new Point(-33,-33));
				}
				blocks.get(1).setLocation(40,40 );//custom na palagay ng blocks 
				blocks.get(2).setLocation(40+width, 40);
				blocks.get(3).setLocation(40+width*2, 40);
				blocks.get(4).setLocation(40+width*4, 40);
				blocks.get(5).setLocation(40+width*6, 40);
				blocks.get(6).setLocation(40+width*8, 40);
				blocks.get(7).setLocation(40+width*10, 40);
				blocks.get(8).setLocation(40+width*10, 40+ height*6);
				blocks.get(9).setLocation(40+width, 40+height);
				blocks.get(10).setLocation(40+width*4, 40+height);
				blocks.get(11).setLocation(40+width*6, 40+height);
				blocks.get(12).setLocation(40+width*8, 40+height);
				blocks.get(13).setLocation(40+width*10, 40+height);
				blocks.get(14).setLocation(40+width, 40+height*2);
				blocks.get(15).setLocation(40+width*4, 40+height*2);
				blocks.get(16).setLocation(40+width*6, 40+height*2);
				blocks.get(17).setLocation(40+width*9, 40+height*2);
				blocks.get(18).setLocation(40+width, 40+height*3);
				blocks.get(19).setLocation(40+width*4, 40+height*3);
				blocks.get(20).setLocation(40+width*6, 40+height*3);
				blocks.get(21).setLocation(40+width*9, 40+height*3);
				blocks.get(22).setLocation(40, 40+height*4);
				blocks.get(23).setLocation(40+width, 40+height*4);
				blocks.get(24).setLocation(40+width*2, 40+height*4);
				blocks.get(25).setLocation(40+width*5, 40+height*4);
				blocks.get(26).setLocation(40+width*9, 40+height*4); 
				//int y=0;
				int y=6;
				int x = 0;
				int count=0;
				for(int i = 27 ; i < blocks.size();i++) 
				//for(int i = 0 ;i< blocks.size();i++)
				{
					blocks.get(i).setLocation(40+(width*x), 40+height*y);
					x++;
					count++;
					if(count == 11)
					{
						count=0;
						x=0;
						y++;
					}
				}
	}
	public void NextLevel()
	{
		
	}
	
	public static void setBlocksLocation(int x, int y,int index)
	{
		
		blocks.get(index).setLocation(x,y);
	}
	
	public static void setBlocksLocation1(int x, int y,int index)
	{
		blocks.get(index).setLocation(x, y);
	}
	
	public void drawBlocks(Graphics g)
	{
		for (int i = 0; i < blocks.size();i++)
		{
			g.setColor(Color.BLACK);
			g.fillRect((int)blocks.get(i).getX(), (int)blocks.get(i).getY(), blockskWidth.get(i), blocksHeight.get(i));
			g.setColor(Color.white);
			g.drawRect((int)blocks.get(i).getX(), (int)blocks.get(i).getY(), blockskWidth.get(i), blocksHeight.get(i));
		}
	}
	
	public void NextLevel3()
	{
	  for(int i = 0; i < 71;i++) //number of blocks 
		//	for(int i = 0; i < 250;i++)
	  			{
					blockskWidth.add(width);
					blocksHeight.add(height);
					blocks.add(new Point(-33, -33));
				}
				blocks.get(1).setLocation(40+ width * 5,40 );//custom na palagay ng blocks 
				blocks.get(2).setLocation(40 + width* 6 ,40);
				blocks.get(3).setLocation(40 + width * 4 , 40 + height + 1);
				blocks.get(4).setLocation(40 + width * 5 , 40 + height);
				blocks.get(5).setLocation(40 + width * 6 , 40 + height);
				blocks.get(6).setLocation(40 + width * 7 , 40 + height);
				blocks.get(7).setLocation(40 + width * 3 , 40 + height +  24);
				blocks.get(8).setLocation(40 + width * 4 , 40 + height * 2);
				blocks.get(9).setLocation(40 + width * 5 , 40 + height * 2);
				blocks.get(10).setLocation(40 + width * 6, 40 + height * 2);
				blocks.get(11).setLocation(40 + width * 7, 40 + height *2);
				blocks.get(12).setLocation(40 + width * 8 , 40 + height * 2);
				blocks.get(13).setLocation(40 + width * 2 , 40 + height + 48);
				blocks.get(14).setLocation(40 + width * 3 , 40 + height * 3);
				blocks.get(15).setLocation(40 + width * 4 , 40 + height * 3);
				blocks.get(16).setLocation(40 + width * 5 , 40 + height * 3);
				blocks.get(17).setLocation(40 + width * 6 , 40 + height * 3);
				blocks.get(18).setLocation(40 + width * 7 , 40 + height * 3);
				blocks.get(19).setLocation(40 + width * 8 , 40 + height * 3);
				blocks.get(20).setLocation(40 + width * 9 , 40 + height * 3);
				blocks.get(21).setLocation(40 + width * 1, 40 + height + 72);
				blocks.get(22).setLocation(40 + width * 2, 40 + height + 72);
				blocks.get(23).setLocation(40 + width * 3, 40 + height + 72);
				blocks.get(24).setLocation(40 + width * 4, 40 + height + 72);
				blocks.get(25).setLocation(40 + width * 5, 40 + height + 72);
				blocks.get(26).setLocation(40 + width * 6, 40 + height + 72);
				blocks.get(27).setLocation(40 + width * 7, 40 + height + 72);
				blocks.get(28).setLocation(40 + width * 8, 40 + height + 72);
				blocks.get(29).setLocation(40 + width * 9, 40 + height + 72);
				blocks.get(30).setLocation(40 + width * 10, 40 + height + 72);
				blocks.get(31).setLocation(40 + width * 2, 40 + height + 95);
				blocks.get(32).setLocation(40 + width * 3, 40 + height + 95);
				blocks.get(33).setLocation(40 + width * 4, 40 + height + 95);
				blocks.get(34).setLocation(40 + width * 5, 40 + height + 95);
				blocks.get(35).setLocation(40 + width * 6, 40 + height + 95);
				blocks.get(36).setLocation(40 + width * 7, 40 + height + 95);
				blocks.get(37).setLocation(40 + width * 8, 40 + height + 95);
				blocks.get(38).setLocation(40 + width * 9, 40 + height + 95);
				blocks.get(39).setLocation(40 + width * 3, 40 + height + 118);
				blocks.get(40).setLocation(40 + width * 4, 40 + height + 118);
				blocks.get(41).setLocation(40 + width * 5, 40 + height + 118);
				blocks.get(42).setLocation(40 + width * 6, 40 + height + 118);
				blocks.get(43).setLocation(40 + width * 7, 40 + height + 118);
				blocks.get(44).setLocation(40 + width * 8, 40 + height + 118);
				blocks.get(45).setLocation(40 + width * 4, 40 + height + 142);
				blocks.get(46).setLocation(40 + width * 5, 40 + height + 142);
				blocks.get(47).setLocation(40 + width * 6, 40 + height + 142);
				blocks.get(48).setLocation(40 + width * 7, 40 + height + 142);
				blocks.get(49).setLocation(40 + width * 5, 40 + height + 166);
				blocks.get(50).setLocation(40 + width * 6, 40 + height + 166);
			
				int y = 9;
				int x = 0;
				int count=0;
				for(int i = 49 ;i < blocks.size();i++) 
				//for(int i = 0 ;i< blocks.size();i++)
				{
					blocks.get(i).setLocation(40+(width*x), 40+height*y);
					x++;
					count++;
					if(count == 11)
					{
						count=0;
						x=0;
						y++;
					}
				}
	}
}

