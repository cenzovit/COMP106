/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the widget/button which, when pressed,
 * switches the drawing area to create ovals.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class circButton extends JButton implements ActionListener, MouseListener {
    private drawArea mArea;

    public circButton (drawArea canvas){
        mArea = canvas;
	setText("Draw Ovals");
        setFont(new Font("Serif", Font.BOLD, 16));
        setBackground(Color.white);
	setForeground(Color.black);
	setBorder(new LineBorder(Color.black, 2));
        addActionListener(this);
	addMouseListener(this);
    }

    public void actionPerformed (ActionEvent e){
        //changes the shape variable of Drawing Area
	mArea.setShape(1);
        System.out.println (getText() + " was pressed. Now drawing Ovals.");
    }

    //when the mouse enters the button, the text becomes red
    public void mouseEntered(MouseEvent e){
        setBackground(Color.black);
        setForeground(Color.red);
    }

    //when the mouse leave the button, the text reverts to black
    public void mouseExited(MouseEvent e){
        setBackground(Color.white);
        setForeground(Color.black);
    }

    // MouseListener defines all of these, so we must supply them                 
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
