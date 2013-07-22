/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will 
 * be a red rectangle.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class redRectangleTile extends Tile {

    public redRectangleTile(int _rIndex, int _cIndex, Board _gameBoard){
	super(_rIndex, _cIndex, Color.RED, _gameBoard);
    }

    public void draw(Graphics g){
	updateInfo();
	if (getHighlighted()){
	    g.setColor(getSelectedColor());
	    g.fillRoundRect(getXLoc(), getYLoc(), getWidth(), getHeight(), 10, 10);
	}
	else{
	    g.setColor(getColor());
	    g.fillRoundRect(getXLoc(), getYLoc(), getWidth(), getHeight(), 10, 10);
	}
    }
}
