package com.npc.BreakOutEntities;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Graphics;

import com.npc.BreakOutEngine.GameEngine;
import com.npc.BreakOutUtilities.*;

public class Ball {
	public static int ballSize;
	public static int index;
	public static boolean isInTop = false;
	public static boolean isInBottom = false;
	public static boolean isInRight = false;
	public static boolean isInLeft = false;
	public Image image;
	String path = "src/pics/blue.png";
	int ballX;
	int ballY;
	
	public Ball()
	{
		index =0;
		ballSize = 15;
		ballX = 0;
		ballY = 0;
	}
	
	public void drawBall(Graphics g) 
	{	//g.setColor(Color.BLACK);
		//g.fillRect(ballX, ballY, ballSize, ballSize);
		//g.drawRect(ballX, ballY, ballSize, ballSize);
		image = Util.LoadImage(path);
		g.drawImage(image , ballX , ballY , ballSize , ballSize , null);
	}
	public void drawBall1(Graphics g)
	{
		image = Util.LoadImage("src/pics/black.png");
		g.drawImage(image, ballX, ballY, ballSize, ballSize, null);
	}
	public void drawBall2(Graphics g)
	{
		image = Util.LoadImage("src/pics/red.png");
		g.drawImage(image, ballX, ballY, ballSize, ballSize, null);
	}
	public Render getRender() {
	        Render r = new Render();
	        r.x = ballX;
	        r.y = ballY;

	        if (image == null) {
	            image = Util.LoadImage("src/pics/blue.png");     
	        }
	        return r;
	  }
	
	public void setBall(int x,int y)
	{
		ballX = x;
		ballY = y;
	}
	public boolean isInTop()
	{
		for(int i = 0; i < Blocks.blocks.size();i++)
		{
			if(Blocks.blocks.get(i).getLocation().y < ballY+ballSize
				&& ballX + ballSize > Blocks.blocks.get(i).getLocation().x
				&& ballX < Blocks.blocks.get(i).getLocation().x + Blocks.blockskWidth.get(i) 
				&& Blocks.blocks.get(i).getLocation().y > ballY)
			{
				
				GameEngine.ballY = Blocks.blocks.get(i).getLocation().y-6;
				index = i; 
				isInTop = true;
			}
		}
		return isInTop;
	}
	
	public boolean isInBottom() 
	{
		for(int i = 0; i < Blocks.blocks.size();i++)
		{
			if(Blocks.blocks.get(i).getLocation().y +  Blocks.blocksHeight.get(i) >ballY
				&& ballX + ballSize > Blocks.blocks.get(i).getLocation().x
				&& ballX < Blocks.blocks.get(i).getLocation().x + Blocks.blockskWidth.get(i) 
				&& Blocks.blocks.get(i).getLocation().y+Blocks.blocksHeight.get(i) < ballY+ballSize)
			{
				GameEngine.ballY = Blocks.blocks.get(i).getLocation().y + Blocks.blocksHeight.get(i);
				index = i;
				isInBottom = true;
			}
		}
		return isInBottom;
	}
	
	public boolean isInRight()
	{
		for(int i = 0; i < Blocks.blocks.size();i++)
		{
			if(Blocks.blocks.get(i).getLocation().x + Blocks.blockskWidth.get(i) > ballX 
				&& ballY < Blocks.blocks.get(i).getLocation().y +  Blocks.blocksHeight.get(i) 
				&& ballY+ballSize  > Blocks.blocks.get(i).getLocation().y 
				&& Blocks.blocks.get(i).getLocation().x+Blocks.blockskWidth.get(i)  < ballX + ballSize)
			{
				GameEngine.ballX = Blocks.blocks.get(i).getLocation().x + Blocks.blockskWidth.get(i);
				index = i;
				isInRight = true;
			}
		}
		return isInRight;
	}
	
	public boolean isInLeft() 
	{
		for(int i = 0; i < Blocks.blocks.size();i++)
		{
			if(Blocks.blocks.get(i).getLocation().x < ballX + ballSize
				&& ballY < Blocks.blocks.get(i).getLocation().y +  Blocks.blocksHeight.get(i) 
				&& ballY+ballSize  > Blocks.blocks.get(i).getLocation().y 
				&& Blocks.blocks.get(i).getLocation().x  > ballX )
			{
				GameEngine.ballX = Blocks.blocks.get(i).getLocation().x-ballSize;
				index = i;
				isInLeft = true;
			}
		}
		return isInLeft;
	}

}

