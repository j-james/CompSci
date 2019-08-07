package zelda;

import processing.core.PApplet;
import processing.core.PImage;

public class Zelda extends PApplet 
{
	PImage lonk;
	PImage bg;

	int lonkX = 600;
	int lonkY = 400;

	boolean movingUp = false;
	boolean movingDown = false;
	boolean movingLeft = false;
	boolean movingRight = false;
	boolean attack = false;

	boolean costumeUp;
	boolean costumeDown;
	boolean costumeLeft;
	boolean costumeRight;

	public static void main(String[] args) 
	{
		PApplet.main("zelda.Zelda");
	}

	public void settings() // background is 510 x 335
	{
		size(1200, 800);
	}

	public void setup() 
	{
		bg = loadImage("start.png");
		lonk = loadImage("lonk_green_walk_down_right.png");
		bg.resize(1200, 0);
		lonk.resize(80, 0);
		// frameRate(30);
	}

	public void draw() 
	{
		loadBackground();
		moveLONK();

	}

	public void loadBackground() 
	{
		background(250);
		imageMode(CORNER);
		image(bg, 0, 0);
	}

	public void keyPressed() 
	{
		if (key == 'w')
			movingUp = true;
		else if (key == 'a')
			movingLeft = true;
		else if (key == 's')
			movingDown = true;
		else if (key == 'd')
			movingRight = true;
		if (key == 'z')
			attack = true;
	}

	public void keyReleased() 
	{
		if (key == 'w')
			movingUp = false;
		if (key == 'a')
			movingLeft = false;
		if (key == 's')
			movingDown = false;
		if (key == 'd')
			movingRight = false;
		if (key == 'z')
			attack = false;
	}

	public void moveLONK() 
	{
		imageMode(CENTER);
		if (movingUp) 
		{
			lonkY -= 20;
			// if (frameRate % 10 == 0)
			// {
				if (attack)
				{
					lonk = loadImage("lonk_green_attack_up_3.png");
					lonk.resize(80, 0);
				}
				else if (costumeUp)
				{
					costumeUp = false;
					lonk = loadImage("lonk_green_walk_up_left.png");
					lonk.resize(65, 0);
				}
				else 
				{
					costumeUp = true;
					lonk = loadImage("lonk_green_walk_up_right.png");
					lonk.resize(65, 0);
				}
			// }
		}
		else if (movingDown) 
		{
			lonkY += 20;
			// if (frameRate % 10 == 0)
			// {
				if (attack)
				{
					lonk = loadImage("lonk_green_attack_down_3.png");
					lonk.resize(140, 0);
				}
				else if (costumeDown)
				{
					costumeDown = false;
					lonk = loadImage("lonk_green_walk_down_left.png");
					lonk.resize(80, 0);
				}
				else 
				{
					costumeDown = true;
					lonk = loadImage("lonk_green_walk_down_right.png");
					lonk.resize(80, 0);
				}
			// }
		}
		else if (movingLeft) {
			lonkX -= 20;
			// if (frameRate % 10 == 0)
			// {
				if (attack)
				{
					lonk = loadImage("lonk_green_attack_left_3.png");
					lonk.resize(140, 0);
				}
				else if (costumeLeft)
				{
					costumeLeft = false;
					lonk = loadImage("lonk_green_walk_left_out.png");
					lonk.resize(80, 0);
				}
				else 
				{
					costumeLeft = true;
					lonk = loadImage("lonk_green_walk_left_in.png");
					lonk.resize(80, 0);
				}
			// }
		}
		else if (movingRight) 
		{
			lonkX += 20;
			// if (frameRate % 5 == 0)
			// {
				if (attack)
				{
					lonk = loadImage("lonk_green_attack_right_3.png");
					lonk.resize(140, 0);
				}
				else if (costumeRight)
				{
					costumeRight = false;
					lonk = loadImage("lonk_green_walk_right_out.png");
					lonk.resize(80, 0);
				}
				else 
				{
					costumeRight = true;
					lonk = loadImage("lonk_green_walk_right_in.png");
					lonk.resize(80, 0);
				}
			// }
		}
		image(lonk, lonkX, lonkY);
		delay(70);
	}

}
