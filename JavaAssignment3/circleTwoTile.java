/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will
 * be a circle with value 2.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class circleTwoTile extends Tile {

    public circleTwoTile(int _rIndex, int _cIndex, Color _color, Board _gameBoard){
        super(_rIndex, _cIndex, _color, _gameBoard, 2);
    }

    public int getValue(){
	return 2;
    }

    public void draw(Graphics g){
	updateInfo();
	if(notDeleted()){
	    if (getHighlighted()){
		g.setColor(getSelectedColor());
		g.fillOval(xLoc, yLoc, mWidth, mHeight);
	    }
	    else{
		g.setColor(getColor());
		g.fillOval(xLoc, yLoc, mWidth, mHeight);
	    }
	}
    }
}
