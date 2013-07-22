/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the combobox which, when changed,
 * edits the tile shape
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class shapeComboBox extends JComboBox implements ActionListener{

  private Tile selectedTile;
  private Game gB;
  private String[] choices = {"Rectangle", "Triangle", "Circle", "Diamond", "Pentagon", "Octagon"};

  public shapeComboBox (Tile _selectedTile, Game _gB) {
    super();
    super.addItem(choices[0]);
    super.addItem(choices[1]);
    super.addItem(choices[2]);
    super.addItem(choices[3]);
    super.addItem(choices[4]);
    super.addItem(choices[5]);
    selectedTile = _selectedTile;
    gB = _gB;
    this.setSelectedItem(selectedTile.getShape());
    addActionListener(this);
  }

  public void actionPerformed(ActionEvent e){
    JComboBox selection = (JComboBox)e.getSource();
    String newShape = (String)selection.getSelectedItem();	
    if (newShape != selectedTile.getShape()){
      gB.changeShape(selectedTile, newShape);
    }
  }

}
