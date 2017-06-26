package com.npc.BreakOutEngine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.npc.BreakOutEntities.Ball;
import com.npc.BreakOutEntities.Bar;
import com.npc.BreakOutEntities.Blocks;
import com.npc.BreakOutUtilities.Keyboard;
import com.npc.BreakOutForm.PlayGame;


public class GameEngine extends JPanel implements Runnable,KeyListener 
{
	private static final long serialVersionUID = 1L;
	public Boolean started;
	private Keyboard keys;
	int barX=20;
	int barY=590;
	public static int ballX=40;
	public static int ballY=600-24;

	int bgWidth = 560;
	int	bgHeight = 600;
	boolean gameOver = false;
	int ballSpeedX = 5;
	int ballSpeedY = -5;
	int count=0;
	SoundEngine sound , dsound;
	Bar bar;
	Ball ball;
	Blocks blocks;
	
	public GameEngine () 
	{
		bar = new Bar();
		ball = new Ball();
		blocks = new Blocks();
		keys = Keyboard.getInstance();
		PlayGame.frame.addKeyListener(this);
		new Thread(this).start();
	}
	@Override
	public void run() 
	{
		try 
		{	
			//sound = new SoundEngine("src/sounds/hard_step1.wav");
			//sound.loop();
			dsound = new SoundEngine("src/sounds/hard_step1.wav");
			sound = new SoundEngine("src/sounds/die1.wav");
			while (true) 
			{
				//dsound.Loop();
	            Thread.sleep(1); 
	            update();
	        }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
	    }
	}
	protected void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(20, 20, bgWidth, bgHeight);
		g.setColor(Color.BLACK);
		g.drawString("Score : " + blocks.score2 , 20 , 650);
		g.setColor(Color.RED);
		g.drawString("Highscore:" +(int)PlayGame.highscore , 500 , 650);
		g.setColor(Color.BLUE);
		
		bar.drawBar(g); 
		ball.drawBall(g);
		blocks.drawBlocks(g);
		if(gameOver == true)
		{	
			g.setColor(Color.BLACK);
			g.setFont(new Font("Courier New", 1, 30));
			g.drawString("GAME OVER", 200, 380);
			g.setFont(new Font("Courier New", 1, 20));
			g.drawString("Press 'R' to Restart", 200, 420);		
		}
	}
	private void update()
	{
		repaint();
		if(gameOver == false)
		{
			if(count %20 == 0)
			{
				List<String> s = new ArrayList<String>();
				if(blocks.score2 > (int)PlayGame.highscore)
				{
					s.add(blocks.score2+"");
					try 
					{
						PlayGame.writeFile("src/Score/Score.txt",s);
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			    try 
			    {
			    	PlayGame.readFile("src/Score/Score.txt");
			    	//System.out.println(PlayGame.highScore);
				} 
			    catch (IOException e1) 
			    {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ballX += ballSpeedX;
				ballY += ballSpeedY;
				if(ballX +  Ball.ballSize > bgWidth+20)
				{
					ballX =  bgWidth - Ball.ballSize + 20; 
					ballSpeedX = -5; 
				}
				if(ballX < 20) 
				{
					ballX =  20;
					ballSpeedX = +5;  
				}
				if(ballY < 20)
				{
					ballY = 20;
					ballSpeedY = +5;
				}
				if(barX < 20)
				{
					barX = 20;
				}
				if(barX + Bar.barWidth > bgWidth + 20) 
				{
					barX = bgWidth - Bar.barWidth + 20;
				}
				if(ballY+Ball.ballSize >barY &&
				ballX+Ball.ballSize > barX && 
				ballX< barX+Bar.barWidth &&
				ballY < barY + 1)
				{
					
					ballY= barY-Ball.ballSize;
					ballSpeedY = -5;
				}
				if(ballY > 750) 
				{
	  			     gameOver = true;
					 sound.Play();
				}
				Blocks.setBlocksLocation1(-33, -33,Ball.index);
			
				if(ball.isInTop())
				{
					ballSpeedY = -5;
					Ball.isInTop = false;
					blocks.score2++;
					dsound.Play();
				}
				if(ball.isInBottom())
				{
					ballSpeedY = 5; 
					Ball.isInBottom = false;
					blocks.score2++;
					dsound.Play();
				}
				if(ball.isInRight())
				{
					ballSpeedX = 5;
					Ball.isInRight = false;
				    blocks.score2++;
					dsound.Play();
				}
				if(ball.isInLeft())
				{
					
					ballSpeedX = -5;
					Ball.isInLeft = false;
					blocks.score2++;
					dsound.Play();
				}
				ball.setBall(ballX, ballY);
				bar.setBar(barX,barY);
			}
		}
		
		count++;
		changeMovement();
	}
	 private void watchForStart() {
	        if (!started && keys.isDown(KeyEvent.VK_SPACE)) {
	            started = true;
	        }
	    }
	private void changeMovement() 
	{
		if (keys.isDown(KeyEvent.VK_A))
		{
			barX -=1;
		}
		else if (keys.isDown(KeyEvent.VK_D))
		{
			barX +=1;
		}
		if (keys.isDown(KeyEvent.VK_R) && gameOver == true)
		{
			gameOver = false;
			 barX=20;
			 barY= 590;
			 ballX=40;
			 ballY= 600-24;
			 count=0;
			 blocks = new Blocks();
			 Ball.index=0;
			blocks.score2 =0;
			
		//	 blocks.initBlocks();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		if(key ==KeyEvent.VK_A )
		{
			
		}	
		if(key ==KeyEvent.VK_D )
		{
			
		}
		if(key ==KeyEvent.VK_SPACE )
		{
			
			
		}
	}	
}
