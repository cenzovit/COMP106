/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will
 * be a diamond with value three.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class diamondThreeTile extends Tile {

  public diamondThreeTile(int _rIndex, int _cIndex, Color _color, Board _gameBoard){
    super(_rIndex, _cIndex, _color, _gameBoard, 3);
  }

  public void draw(Graphics g){
    updateInfo();
    if(notDeleted()){
      Point p1 = new Point(xLoc + (mWidth/2), yLoc);
      Point p2 = new Point(xLoc + mWidth, yLoc + (mHeight/2));
      Point p3 = new Point(xLoc + (mWidth/2), yLoc + mHeight);
      Point p4 = new Point(xLoc, yLoc + (mHeight/2));
      int[] xLocs = {p1.x, p2.x, p3.x, p4.x};
      int[] yLocs = {p1.y, p2.y, p3.y, p4.y};

      if (getHighlighted()){
        g.setColor(getSelectedColor());
        g.fillPolygon(xLocs, yLocs, 4);
      }
      else{
        g.setColor(getColor());
        g.fillPolygon(xLocs, yLocs, 4);
      }
    }
  }
}
