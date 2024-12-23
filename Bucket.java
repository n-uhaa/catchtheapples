//Nuha Samen & Emaan Taswar
//January 8th 2023
//Summative Project - catch the apples: A fun game to test your reaction time!
//Bucket class - uses input to controls the basket to catch the apples 
import java.awt.*;
import java.awt.event.*;

//class paddles to control all paddle related movement
public class Bucket extends Rectangle {
	
	private int xVelocity;
	private static final int SPEED = 5;
	public static final int BUCKET_WIDTH = 75;
	public static final int BUCKET_HEIGHT = 90;
	
	//paddles constructor to set location of paddles based on given coordinates
	public Bucket(int x, int y, int player){
		
		super(x,y,BUCKET_WIDTH,BUCKET_HEIGHT);
		xVelocity = 0;
	
	}
	
	//method to change y direction of the bucket (left or right)
	private void setXDir(int XDirection) {
		xVelocity = XDirection;
	}
	
	//key pressed constructor to interpret keys as movement of the bucket
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_A) { 
				setXDir(-1*SPEED);
				move();
			}
		if(e.getKeyCode()==KeyEvent.VK_D) {
				setXDir(SPEED);
				move();
			}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				setXDir(-1*SPEED);
				move();
			}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				setXDir(SPEED);
				move();
			}
	
		
	}
	
	//key released method sets every key release to not have any movement
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_D ) {
			setXDir(0);
			move();
		}
	
		if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT) {
			setXDir(0);
			move();
		}
		
	}
	
	//move method used to update the current location of the basket
	public void move() {
		x = x + xVelocity;
	}
	
	//draw method to display the basket on screen
	public void draw(Graphics g) {
		
		g.setColor(Color.orange);
		g.fillRect(x,y,width,height);
	}
}
  