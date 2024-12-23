//Nuha Samen & Emaan Taswar
//January 8th 2023
//Summative Project - catch the apples: A fun game to test your reaction time!
//gameframe panel - controls the settings of the frame and controls movement between different panels


import javax.swing.*;


public class GameFrame extends JFrame{
	
	//declaring variables
	private GamePanel game;
	private StartPanel start;
	private EndPanel end;
	private InstructionsPanel inst;
	private ChoicePanel choice;
	
	//constructor method to set all required frame settings
	GameFrame() {
	
		//create new objects - panels 
		start = new StartPanel(this);
        game = new GamePanel(this);
        end = new EndPanel(this);
        inst = new InstructionsPanel(this);
        choice = new ChoicePanel(this);

        	// initalize frame settings 
		 	this.add(start);
		 	this.setSize(800,560);
		 	this.setTitle("Catch The Apples!");
			this.setResizable(false); // does not allow the user to resize
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
	
	//method switchs to game panel by removing the contents of the present panel and repainting with the new game panel
	public void switchToGamePanel() {
		
		//set variables to 0 to reset game
		Score.playerScore = 0;
		Score.lives = 0;
        getContentPane().removeAll(); //clears all content from current panel
        getContentPane().add(game); // displays all conetnt from game panle
        game.requestFocusInWindow(); //allows input to be accepted from panel
        revalidate();  
        repaint();
        game.newApple(); //creates new apple
    }
	// Method to switch back to the StartPanel
    public void switchToChoicePanel() {
        getContentPane().removeAll();
        getContentPane().add(choice);
        revalidate();
        repaint();
    }
    

    // Method to switch back to the StartPanel
    public void switchToStartPanel() {
        getContentPane().removeAll();
        getContentPane().add(start);
        revalidate();
        repaint();
    }
    
    // Method to switch to the end panel once game ends
    public void switchToEndPanel() {
        getContentPane().removeAll();
        getContentPane().add(end);
        revalidate();
        repaint();
    }
    
    // Method to switch back to the instructions 
    public void switchToInstructionPanel() {
        getContentPane().removeAll();
        getContentPane().add(inst);
        revalidate();
        repaint();
    }
    
    
}
