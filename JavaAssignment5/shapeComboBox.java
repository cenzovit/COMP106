/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the combobox which, when changed,
 * edits which shape is selected to be rotated.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class shapeComboBox extends JComboBox implements ActionListener{
    
    private guiControlPanel controls;
    private String[] choices = {"Cube", "Sphere", "Cone", "Cylinder"};
    
    public shapeComboBox (guiControlPanel _controls) {
	super();
	super.addItem(choices[0]);
	super.addItem(choices[1]);
	super.addItem(choices[2]);
	super.addItem(choices[3]);
	controls = _controls;
	this.setSelectedIndex(0);
	addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
	JComboBox selection = (JComboBox)e.getSource();
	String newShape = (String)selection.getSelectedItem();	
	if (newShape != controls.getCurrShape()){
	    this.setSelectedItem(newShape);
	    controls.changeShape(newShape);
	}
    }
    
}
