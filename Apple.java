//Nuha Samen & Emaan Taswar
//January 8th 2023
//Summative Project - catch the apples: A fun game to test your reaction time!
//Apple class - controls the apples movements and configurations 

import java.awt.*;



public class Apple extends Rectangle{

	
	public static int speed;
	private static final int DIAMETER = 30;
	private static int yVelocity;

	
	//constructor creates apple at given location with given dimensions
	public Apple(int x, int y){
		
		super(x, y, DIAMETER, DIAMETER);
		setYDir(1);
		
	}

	//set y direction method changes movement of the apple changes in the y-direction
	public static void setYDir(int randY) {
		yVelocity = randY;
		
	}	

	//move method updates the current location of the apple
	public void move() {
		y += (yVelocity*speed);
		
	}
	
	//displays the current location of the ball on the screen
	public void draw(Graphics g) {
		//paint(g2D);
		g.setColor(Color.red);
		g.fillOval(x,y,DIAMETER,DIAMETER);
	}
}
