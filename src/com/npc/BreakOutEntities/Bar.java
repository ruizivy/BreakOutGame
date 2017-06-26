package com.npc.BreakOutEntities;

import java.awt.Color;
import java.awt.Graphics;

public class Bar 
{
	public static  int barWidth = 96;
	public static  int barHeight = 24;
	public static int barX;
	private int barY;

	public Bar()

	{
		barX = 0;
		barY = 0;
	}
	
	public void drawBar(Graphics g) 
	{
		g.fillRect(barX, barY, barWidth, barHeight);
		g.setColor(Color.BLACK);
		g.drawRect(barX, barY, barWidth, barHeight);
	}
	
	public void setBar(int x,int y)
	{
		barX = x;
		barY = y;
	}	
}

