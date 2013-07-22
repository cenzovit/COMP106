/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will 
 * be a rectangle with value 0.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class rectangleZeroTile extends Tile {

    public rectangleZeroTile(int _rIndex, int _cIndex, Color _color, Board _gameBoard){
	super(_rIndex, _cIndex, _color, _gameBoard, 0);
    }
    
    public int getValue(){
	return 0;
    }

    public void draw(Graphics g){
	updateInfo();
	if(notDeleted()){
	    if (getHighlighted()){
		g.setColor(getSelectedColor());
		g.fillRoundRect(xLoc, yLoc, mWidth, mHeight, 10, 10);
	    }
	    else{
		g.setColor(getColor());
		g.fillRoundRect(xLoc, yLoc, mWidth, mHeight, 10, 10);
	    }
	}
    }
}
