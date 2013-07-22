/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will
 * be a octagon with value five.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class octagonFiveTile extends Tile {

  public octagonFiveTile(int _rIndex, int _cIndex, Color _color, Board _gameBoard){
    super(_rIndex, _cIndex, _color, _gameBoard, 5);
  }

  public void draw(Graphics g){
    updateInfo();
    if(notDeleted()){
      Point p1 = new Point(xLoc + (mWidth/3), yLoc);
      Point p2 = new Point(xLoc + 2*(mWidth/3), yLoc);
      Point p3 = new Point(xLoc + mWidth, yLoc + (mHeight/3));
      Point p4 = new Point(xLoc + mWidth, yLoc + 2*(mHeight/3));
      Point p5 = new Point(xLoc + 2*(mWidth/3), yLoc + mHeight);
      Point p6 = new Point(xLoc + (mWidth/3), yLoc + mHeight);
      Point p7 = new Point(xLoc, yLoc + 2*(mHeight/3));
      Point p8 = new Point(xLoc, yLoc + (mHeight/3));
      int[] xLocs = {p1.x, p2.x, p3.x, p4.x, p5.x, p6.x, p7.x, p8.x};
      int[] yLocs = {p1.y, p2.y, p3.y, p4.y, p5.y, p6.y, p7.y, p8.y};

      if (getHighlighted()){
        g.setColor(getSelectedColor());
        g.fillPolygon(xLocs, yLocs, 8);
      }
      else{
        g.setColor(getColor());
        g.fillPolygon(xLocs, yLocs, 8);
      }
    }
  }
}
