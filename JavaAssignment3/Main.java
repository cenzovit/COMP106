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
	
	//create the state panel
	JPanel states = new JPanel();
	states.setBorder(new LineBorder(Color.black, 2));
        states.setLayout(new FlowLayout());
	
	//create the gameBoard
	Game gB = new Game(states);
	gB.setBorder(new LineBorder(Color.black, 2));
        //add gameBoard to the content container
	content.add(gB, BorderLayout.CENTER);

	//create the control panel
	JPanel controls = new JPanel();
	controls.setBorder(new LineBorder(Color.black, 2));
	controls.setLayout(new FlowLayout());
	
	//create and add my widgets/buttons to the control panel
	newGameButton b1 = new newGameButton(gB);
	resetColorsButton b2 = new resetColorsButton(gB);
	randomColorsButton b3 = new randomColorsButton(gB);
	quitButton b4 = new quitButton();
	controls.add(b1);
	controls.add(b2);
	controls.add(b3);
	controls.add(b4);
	
	//add control panel to the content container
	content.add(controls, BorderLayout.SOUTH);
	
	//add state panel to the content container
	content.add(states, BorderLayout.NORTH);

	setVisible(true);
    }
}
