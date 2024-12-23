//Summative Project - catch the apples: A fun game to test your reaction time!
//end panel - controls end screen, displays score and allows user to restart or go back to main

//import libraries
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EndPanel extends JPanel implements ActionListener {
	
	//declare variables
	private JButton playAgain;
    private JButton backToMain;
    private Image background;
    private ImageIcon obj;
    private GameFrame frame;
 

	public EndPanel(GameFrame frame) {
		
		this.frame = frame; //initialize frame
    	
		//set spacing and alignment for elecments on panel
        setLayout(new FlowLayout(FlowLayout.RIGHT, 55, 260)); 

        //initialize buttons
        playAgain = new JButton("Play Again");
        backToMain = new JButton("Return to Main");
        
        //detect input from buttons
        playAgain.addActionListener(this);
        backToMain.addActionListener(this);

        //display buttons
        add(playAgain);
        add(backToMain);

        // Load background image
        obj = new ImageIcon("end.png");
        background = obj.getImage();
	}
	
	//use paint component method to display background and elements
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        
        //displau final score 
        g.setFont(new Font("monospaced",Font.PLAIN,20));
        g.drawString("Final Score: "+Score.playerScore, 510, 230);
    }

	//method dectects input from mouse
    public void actionPerformed(ActionEvent action) {
    	
    	//switch to panel according to button pressed by user
        if (action.getSource() == playAgain) {
        	frame.switchToChoicePanel();
			
        } else if (action.getSource() == backToMain) {
        	frame.switchToStartPanel();
        }
    }

	

}
