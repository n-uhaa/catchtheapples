//Summative Project - catch the apples: A fun game to test your reaction time!
//Score class to calculate and display score of each player, also control the lives count

import java.awt.*;


public class Score extends Rectangle{


	public static int playerScore;
	public static int lives;
	private GameFrame frame;
	
	//constructor sets where score will be displayed
	public Score(GameFrame frame) {
		
		playerScore = 0;
		lives = 0;
		this.frame = frame;
		
	}
	
	//method cheeck to see if player has exceeded number of lives ending game
	public void checkGameOver() {
		if (lives == 3) 
			frame.switchToEndPanel();
	}
	
	//draw method displays score on screen
	public void draw(Graphics g) {
		
		//set specifications for font to be displayed
		g.setColor(Color.red);
		g.fillRect(635, 25, 150, 35);
		g.fillRect(25, 25, 150, 35);
		g.setColor(Color.white);
		g.setFont(new Font("MONOSPACED",Font.BOLD,19));
		
		//display score based on counter value
		g.drawString(String.valueOf("Score: "+ playerScore), 30, 50);

		//display lives based on counter value
		if (lives == 0)
			g.drawString(("Lives: X X X"), 640, 50);
		else if (lives == 1)
			g.drawString(("Lives: X X "), 640, 50);
		else if (lives == 2)
			g.drawString(("Lives: X"), 640, 50);
		
	}
}
