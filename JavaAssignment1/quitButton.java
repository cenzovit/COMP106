/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the widget/button which, when pressed,
 * exits the running applet
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class quitButton extends JButton implements ActionListener, MouseListener {
    
    public quitButton () {
	setText("Exit");
        setFont(new Font("Serif", Font.BOLD, 16));
        setBackground(Color.white);
        setForeground(Color.black);
        setBorder(new LineBorder(Color.black, 2));
        addActionListener(this);
	addMouseListener(this);
    }

    public void actionPerformed (ActionEvent e) {
        System.out.println(getText() + " was pressed. Applet Exited.");
	//exit the applet
	System.exit(0);
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
