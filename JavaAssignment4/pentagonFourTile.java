/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will
 * be a pentagon with value four.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class pentagonFourTile extends Tile {

  public pentagonFourTile(int _rIndex, int _cIndex, Color _color, Board _gameBoard){
    super(_rIndex, _cIndex, _color, _gameBoard, 4);
  }

  public void draw(Graphics g){
    updateInfo();
    if(notDeleted()){
      Point p1 = new Point(xLoc + (mWidth/2), yLoc);
      Point p2 = new Point(xLoc + mWidth, yLoc + 4*(mHeight/9));
      Point p3 = new Point(xLoc + 3*(mWidth/4), yLoc + mHeight);
      Point p4 = new Point(xLoc + (mWidth/4), yLoc + mHeight);
      Point p5 = new Point(xLoc, yLoc + 4*(mHeight/9));
      int[] xLocs = {p1.x, p2.x, p3.x, p4.x, p5.x};
      int[] yLocs = {p1.y, p2.y, p3.y, p4.y, p5.y};

      if (getHighlighted()){
        g.setColor(getSelectedColor());
        g.fillPolygon(xLocs, yLocs, 5);
      }
      else{
        g.setColor(getColor());
        g.fillPolygon(xLocs, yLocs, 5);
      }
    }
  }
}
