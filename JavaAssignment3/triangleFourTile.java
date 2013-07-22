/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will
 * be a triangle with value four.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class triangleFourTile extends Tile {

    public triangleFourTile(int _rIndex, int _cIndex, Color _color, Board _gameBoard){
        super(_rIndex, _cIndex, _color, _gameBoard, 4);
    }

    public int getValue(){
	return 4;
    }
    
    public void draw(Graphics g){
	updateInfo();
	if(notDeleted()){
	    Point p1 = new Point(xLoc + (mWidth/2), yLoc);
	    Point p2 = new Point(xLoc + mWidth, yLoc + mHeight);
	    Point p3 = new Point(xLoc, yLoc + mHeight);
	    int[] xLocs = {p1.x, p2.x, p3.x};
	    int[] yLocs = {p1.y, p2.y, p3.y};
	    
	    if (getHighlighted()){
		g.setColor(getSelectedColor());
		g.fillPolygon(xLocs, yLocs, 3);
	    }
	    else{
		g.setColor(getColor());
		g.fillPolygon(xLocs, yLocs, 3);
	    }
	}
    }
}
