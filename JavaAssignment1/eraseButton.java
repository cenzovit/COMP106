/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the widget/button which, when pressed,
 * clears the drawing area of all shapes
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class eraseButton extends JButton implements ActionListener, MouseListener {
    private drawArea mArea;

    public eraseButton (drawArea canvas) {
	mArea = canvas;
        setText("Erase Canvas");
        setFont(new Font("Serif", Font.BOLD, 16));
        setBackground(Color.white);
        setForeground(Color.black);
        setBorder(new LineBorder(Color.black, 2));
        addActionListener(this);
	addMouseListener(this);
    }

    public void actionPerformed (ActionEvent e) {
	//clear the Drawing Area of shapes
	mArea.removeShapes();
        System.out.println(getText() + " was pressed. Canvas Cleared.");
    }

    //when the mouse enters the button, the text becomes red
    public void mouseEntered(MouseEvent e){
        setBackground(Color.black);
        setForeground(Color.red);
    }

    //when the mouse leaves the button, the text reverts to black
    public void mouseExited(MouseEvent e){
        setBackground(Color.white);
        setForeground(Color.black);
    }

    // MouseListener defines all of these, so we must supply them                 
    public void mousePressed(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

}
