/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the menu that will pop up
 * when the user right clicks on the game board.
 * The menu will contain options to control the
 * audio.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;
import java.applet.*;

public class musicPopUpMenu extends JPopupMenu {

  private audio music;

  public musicPopUpMenu(audio _music){
    music = _music;
    JMenuItem pause = new JMenuItem("Pause Music");
    JMenuItem reset = new JMenuItem("Reset Current Song");
    JMenuItem next = new JMenuItem("Next Song");
    JMenuItem play = new JMenuItem("Play Music");
    pause.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        music.pause();
      }
    });
    reset.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        music.reset();
      }
    });
    next.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        music.next();
      }
    });
    play.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        music.play();
      }
    });
    if (music.getPaused() == 0){
      add(pause);
      add(reset);
      add(next);
    }
    else{
      add(play);
      add(reset);
      add(next);
    }
  }
}
