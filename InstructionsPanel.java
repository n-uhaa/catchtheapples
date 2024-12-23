//Summative Project - catch the apples: A fun game to test your reaction time!
//instruction panel - controls the graphics and button on this panel

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InstructionsPanel extends JPanel implements ActionListener {
	
	//declare variables
    private JButton backToMain;
    private Image background;
    private GameFrame frame;
 

	public InstructionsPanel(GameFrame frame) {
		//initalize frame
		this.frame = frame;
    	
		//set layout for alignment ang position of button
        setLayout(new FlowLayout(FlowLayout.RIGHT, 55, 440)); // Centered FlowLayout with spacing

        //initalize button
        backToMain = new JButton("Return to Main");
       
        //accept input from button
        backToMain.addActionListener(this);

        //display button
        add(backToMain);

        // Load background image
        ImageIcon obj = new ImageIcon("instructions.png");
        background = obj.getImage();
	}

	
	//paint component method to display background and elements
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        
    }

	//method detects mouse input
    public void actionPerformed(ActionEvent action) {
     
    	//if button is pressed corresponding panel is opened
       if (action.getSource() == backToMain) {
        	frame.switchToStartPanel();
        }
    }

	

}
