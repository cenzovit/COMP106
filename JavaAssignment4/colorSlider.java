/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the slider which, when moves,
 * edits the tile color (and all similiar tiles)
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class colorSlider extends JSlider implements ChangeListener{

  private Tile selectedTile;
  private Game gB;
  private int test;

  public colorSlider (Tile _selectedTile, Game _gB, int _test) {
    super(0,255);
    selectedTile = _selectedTile;
    gB = _gB;
    test = _test;
    init();
    addChangeListener(this);
  }

  private void init(){
    int colorVal = 0;
    if (test == 1){
      colorVal = selectedTile.getColor().getRed();
    }
    else if (test == 2){
      colorVal = selectedTile.getColor().getGreen();
    }
    else{
      colorVal = selectedTile.getColor().getBlue();
    }
    this.setValue(colorVal);
  }

  public void stateChanged(ChangeEvent e){
    JSlider source = (JSlider)e.getSource();
    Color tileColor = selectedTile.getColor();
    if (!source.getValueIsAdjusting()){
      Color newColor;
      if (test == 1){
        newColor = new Color((int)source.getValue(), tileColor.getGreen(), tileColor.getBlue()); 
      }
      else if (test == 2){
        newColor = new Color(tileColor.getRed(), (int)source.getValue(), tileColor.getBlue()); 
      }
      else{
        newColor = new Color(tileColor.getRed(), tileColor.getGreen(), (int)source.getValue()); 
      }
      gB.changeColor(newColor, selectedTile.getValue());
    }
  }
}
