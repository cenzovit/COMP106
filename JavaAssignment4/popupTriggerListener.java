/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the class which is a 
 * cunstom actionlistener to be added to the 
 * game board in order to implement musicPopUpMenu 
 * class.
 *
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;
import java.applet.*;

public class popupTriggerListener extends MouseAdapter {

  private audio music;

  public popupTriggerListener(audio _music){
    music = _music;
  }

  public void mousePressed(MouseEvent e){
    if(e.isPopupTrigger()){
      popUp(e);
    }
  }

  public void mouseReleased(MouseEvent e){
    if(e.isPopupTrigger()){
      popUp(e);
    }
  }

  private void popUp(MouseEvent e){
    musicPopUpMenu menu = new musicPopUpMenu(music);
    menu.show(e.getComponent(), e.getX(), e.getY());
  }

  //defined in MouseAdapter
  public void mouseClicked(MouseEvent e){}
}
