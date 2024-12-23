//Nuha Samen & Emaan Taswar
//January 8th 2023
//Summative Project - catch the apples: A fun game to test your reaction time!
//start panel - controls the introduction panel including the buttons and graphics

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartPanel extends JPanel implements ActionListener {


	private JButton play;
    private JButton rules;
    private Image background;
    public GameFrame frame;
    private ImageIcon obj;
 

    public StartPanel(GameFrame frame) {
    	
    	this.frame = frame;
    	
        setLayout(new FlowLayout(FlowLayout.RIGHT, 55, 250)); // Centered FlowLayout with spacing

        //initalize buttons
        play = new JButton("START!");
        rules = new JButton("How To Play");
        
        //detect input from buttons
        play.addActionListener(this);
        rules.addActionListener(this);
        
        //display buttons
        add(play);
        add(rules);

        //Load background image
        obj = new ImageIcon("start.png");
        background = obj.getImage();
    }

    //method to paint items on panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    //method to detect mouse action
    public void actionPerformed(ActionEvent action) {
    	
    	//if statement to switch to indicated panel
        if (action.getSource() == play) {
        	frame.switchToChoicePanel();
			
        } else if (action.getSource() == rules) {
        	frame.switchToInstructionPanel();
        }
    }

 
}
