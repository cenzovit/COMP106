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

    Container content;
    JPanel states;
    guiControlPanel controls;
    Game gB;

    //set-up the display area
    setLocation(100, 100);
    setSize(600, 800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    //init the container for the content
    content = getContentPane();
    content.setLayout(new BorderLayout());

    //init the state panel
    states = new JPanel();
    states.setBorder(new LineBorder(Color.black, 2));
    states.setLayout(new FlowLayout());

    //init the gameBoard
    gB = new Game(states);
    gB.setBorder(new LineBorder(Color.black, 2));

    //init the control panel
    controls = new guiControlPanel(content, gB);

    //add the control panel to the GameBoard
    gB.addControlPanel(controls);

    //add gameBoard to the content container
    content.add(gB, BorderLayout.CENTER);

    //add control panel to the content container
    content.add(controls, BorderLayout.SOUTH);

    //add state panel to the content container
    content.add(states, BorderLayout.NORTH);

    setVisible(true);
  }
}
