//Nuha Samen & Emaan Taswar
//January 8th 2023
//Summative Project - catch the apples: A fun game to test your reaction time!
/*choice panel class - controls the panel that allows user to choose difficulty level
controls the 3 buttons on the screen and uses input to change speed/difficulty of the game*/

//import libraries
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ChoicePanel extends JPanel implements ActionListener{
	
	//declare variables
	private JButton easy;
    private JButton challenging;
    private JButton extreme;
    private Image background;
    private ImageIcon obj;
    public GameFrame frame;
    
    public ChoicePanel(GameFrame frame) {
    	
    	//declare fram
    	this.frame = frame;
    	
    	//space and align elements on panel
    	setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 260)); 
    	
    	//initialize buttons
    	easy = new JButton("EASY");
		challenging = new JButton("CHALLENGING");
		extreme = new JButton("EXTREME");

		//accepting input from buttons
		easy.addActionListener(this);
        challenging.addActionListener(this);
        extreme.addActionListener(this);

		//display buttons on screem
        add(easy);
		add(challenging);
		add(extreme);
		
		// Load background image
		obj = new ImageIcon("start.png");
        background = obj.getImage();
        
    }
    
    //actions performed method to dected and accept input
    public void actionPerformed(ActionEvent action) {
    	
    	//set speed of apple based on difficulty chose 
        if (action.getSource() == easy) 
        	Apple.speed = 4;
        else if (action.getSource() == challenging) 
        	Apple.speed = 5;
        else if (action.getSource() == extreme) 
        	Apple.speed = 6;
        //switch to game panel
        frame.switchToGamePanel();
    }
    
    //paint method used to display background and string elements
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        g.drawString("Choose a difficulty level:",505,230);
        g.drawString("**The higher the difficulty the faster the ball moves**",435,320);
    }

}

