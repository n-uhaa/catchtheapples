//Nuha Samen & Emaan Taswar
//January 8th 2023
//Summative Project - catch the apples: A fun game to test your reaction time!
//game panel class -  controls all the objects and grpahics in the game allowing the gamme to function

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


//GamePanel class acts as the main "game loop" - continuously runs the game and calls various methods
public class GamePanel extends JPanel implements Runnable, KeyListener {

	//delcare static variables
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 550;
	
	int xPosition;
	
	//initialize objects
	public Thread gameThread;
	public Image img;
	public Image pic;
	public ImageIcon obj; 
	public Graphics graphics;	
	public Bucket bucket;
	public Apple apple;
	public Score score;
	public Random rand = new Random();
	public GameFrame frame;
	
	public GamePanel(GameFrame frame) {
		
		//initialize variables
		this.frame = frame;
		obj = new ImageIcon("background.jpg");
		pic = obj.getImage();
		

		//create new objects, 2 paddles a apple and the score
		bucket = new Bucket((GAME_WIDTH/2),460,1);
		score = new Score(frame);
		//new apple method is used to generate apple since it will be used several times
		newApple();
		
		//initialize settings of the game panel
		this.setFocusable(true);
		this.addKeyListener(this);
		
		
		//use threading to reduce lag and run multiples methods at once
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	

	//new apple method creates new apple in the middle of the screen
	public void newApple() {
		
		//create apple at new x coordinate
		xPosition = rand.nextInt(15,785);
		apple = new Apple(xPosition,15);
		
	}

	//to avoid using the paint method we are overriding it to move the images on screen after drawn
	//this reduces lag and makes the motions more fluid
	public void paint(Graphics g) {
		img = createImage(getWidth(),getHeight());
		graphics = img.getGraphics();
		draw(graphics);
		g.drawImage(img, 0, 0, this);
		
	}	
	
	//updates and displays the position of objects as they move
	public void draw(Graphics g) {
		
		g.drawImage(pic, 0, 0, null);
		bucket.draw(g);
		apple.draw(g);
		score.draw(g);
	}
	
	//move method to make movement appear with less lag and more fluid
	public void move() {
		bucket.move();
		apple.move();
	
	}
	
	//handles all collision detection and responds accordingly
	public void checkCollision() {
		
		//using if to detect collision of the bucket
		//this stops the bucket at the edges of the window
		if(bucket.x<=0)
			bucket.x=0;
		
		if(bucket.x >= (GAME_WIDTH-Bucket.BUCKET_WIDTH))
			bucket.x = (GAME_WIDTH-Bucket.BUCKET_WIDTH);
		
		
		//detecting if the apple reaches the bottom edge of the screen
		//and adding to lives used up
		if(apple.y >= (GAME_HEIGHT-80)) {
			Score.lives++; // add one to lives count
			newApple(); 
		}
		//dectects collision between apple and bucket causing played to earn a point
		if (apple.intersects(bucket)) {
			Score.playerScore++; //add one to score
			newApple(); //generates new apple
		}
		
		
	}

	//continues running the game and updates various aspects by calling methods
	public void run() {
		
		long lastTime  = System.nanoTime();
		double ticks = 60.0;
		double ns = 1000000000 / ticks;
		double delta =0;
		
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if (delta>=1) {
				checkCollision();
				repaint();
				move();
				score.checkGameOver();
				delta--;				
			}
		}
		
	}
	
	public void keyTyped(KeyEvent e){

	  }

	//processes a pressed key 
	public void keyPressed(KeyEvent e) {
		bucket.keyPressed(e);
	
	}

	//processes a released key
	public void keyReleased(KeyEvent e) {
		bucket.keyReleased(e);
		
	}
}
