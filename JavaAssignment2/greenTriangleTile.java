/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will
 * be a green triangle.
 *
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class greenTriangleTile extends Tile {

    public greenTriangleTile(int _rIndex, int _cIndex, Board _gameBoard){
        super(_rIndex, _cIndex, Color.GREEN, _gameBoard);
    }

    public void draw(Graphics g){
	updateInfo();
	Point p1 = new Point(getXLoc() + (getWidth()/2), getYLoc());
	Point p2 = new Point(getXLoc() + getWidth(), getYLoc() + getHeight());
	Point p3 = new Point(getXLoc(), getYLoc() + getHeight());
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
