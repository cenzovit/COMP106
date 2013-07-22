/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 * 
 * This file contains the Main routine of my program.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.Object.*;

public class Main extends JFrame {
    
    public static void main(String[] args){
	new Main();
    }

    public Main(){
       
	//set-up the display area
	setLocation(100, 100);
	setSize(600, 800);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	//create a container for the content
	Container content = getContentPane();
	content.setLayout(new BorderLayout());
	
	//create the gameBoard
	Game gB = new Game();
	gB.setBorder(new LineBorder(Color.black, 2));
        //add gameBoard to the content container
	content.add(gB, BorderLayout.CENTER);

	//create the control panel
	JPanel controls = new JPanel();
	controls.setBorder(new LineBorder(Color.black, 2));
	controls.setLayout(new FlowLayout());
	
	//create and add my widgets/buttons to the control panel
	quitButton b1 = new quitButton();
	controls.add(b1);
	
	//add control panel to the content container
	content.add(controls, BorderLayout.SOUTH);
	
	//create the state panel
	JPanel states = new JPanel();
	states.setBorder(new LineBorder(Color.black, 2));
        states.setLayout(new FlowLayout());

	//create and add text label for the empty state panel
	JLabel stateLabel = new JLabel();
	stateLabel.setText("This is the State Panel (will later contain timer and score)");
	states.add(stateLabel);

	//add state panel to the content container
	content.add(states, BorderLayout.NORTH);

	setVisible(true);
    }
}
