/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the tile which will
 * be a blue circle.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class blueCircleTile extends Tile {

    public blueCircleTile(int _rIndex, int _cIndex, Board _gameBoard){
        super(_rIndex, _cIndex, Color.BLUE, _gameBoard);
    }

    public void draw(Graphics g){
	updateInfo();
	if (getHighlighted()){
            g.setColor(getSelectedColor());
            g.fillOval(getXLoc(), getYLoc(), getWidth(), getHeight());
	}
        else{
            g.setColor(getColor());
            g.fillOval(getXLoc(), getYLoc(), getWidth(), getHeight());
	}
    }
}
