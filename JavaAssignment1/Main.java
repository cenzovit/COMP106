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

public class Main extends JFrame {
    
    public static void main(String[] args){
	new Main();
    }

    public Main(){
       
	//set-up the display area
	setLocation (100, 100);
	setSize (600, 800);
	setDefaultCloseOperation (EXIT_ON_CLOSE);
	
	//create a container for the content
	Container content = getContentPane();
	content.setLayout(new BorderLayout());

	//create the drawing area
	drawArea mArea = new drawArea();
	mArea.setBorder(new LineBorder(Color.black, 2));
	//add drawing area to the content container
	content.add(mArea, BorderLayout.CENTER);

	//create the control panel
	JPanel controls = new JPanel();
	controls.setBorder(new LineBorder(Color.black, 2));
	controls.setLayout(new FlowLayout());
	
	//create and add my widgets/buttons to the control panel
	rectButton b1 = new rectButton(mArea);
	controls.add(b1);
	circButton b2 = new circButton(mArea);
	controls.add(b2);
	eraseButton b3 = new eraseButton(mArea);
	controls.add(b3);
	quitButton b4 = new quitButton();
	controls.add(b4);

	//add control panel to the content container
	content.add(controls, BorderLayout.SOUTH);
	
	//create the state panel
	JPanel states = new JPanel();
	states.setBorder(new LineBorder(Color.black, 2));
        states.setLayout(new FlowLayout());

	//create and add text label for the empty state panel
	JLabel stateLabel = new JLabel();
	stateLabel.setText("This is the State Panel");
	states.add(stateLabel);

	//add state panel to the content container
	content.add(states, BorderLayout.NORTH);

	setVisible(true);

    }

}
