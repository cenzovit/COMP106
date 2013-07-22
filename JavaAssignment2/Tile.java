/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the abstract class tile, which will be
 * inherited by all of the tiles to be used in the "bejeweled"
 * game board.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public abstract class Tile {

    private Board gameBoard;
    private int rIndex, cIndex;
    private int xLoc, yLoc, mWidth, mHeight;
    private Color normCol, selectCol;
    private boolean highlighted, selected;

    public Tile(int _rIndex, int _cIndex, Color _col, Board _gameBoard){
	gameBoard = _gameBoard;
	updateInfo();
	rIndex = _rIndex;
	cIndex = _cIndex;
	normCol = _col;
	selectCol = _col.darker();
	highlighted = false;
	selected = false;
    }
    
    public void updateInfo(){
        int gridWidth = gameBoard.getWidth()/8;
        int gridHeight = gameBoard.getHeight()/8;
        xLoc = (rIndex*gridWidth) + 10;
        yLoc = (cIndex*gridHeight) + 10;
        mWidth = gridWidth - 20;
        mHeight = gridHeight - 20;
    }

    public int getXLoc(){
	return xLoc;
    }

    public int getYLoc(){
	return yLoc;
    }

    public int getWidth(){
	return mWidth;
    }

    public int getHeight(){
	return mHeight;
    }
    
    public Color getColor(){
	return normCol;
    }
    
    public Color getSelectedColor(){
	return selectCol;
    }
    
    public int getRowIndex(){
	return rIndex;
    }
    
    public int getColIndex(){
	return cIndex;
    }
    
    public Board getBoard(){
	return gameBoard;
    }
    
    public void setHighlighted(boolean _highlighted){
	highlighted = _highlighted;
    }

    public void setSelected(boolean _selected){
	selected = _selected;
    }

    public boolean getHighlighted(){
	return highlighted;
    }

    public boolean getSelected(){
	return selected;
    }
   
    //method to give a tile a new row and col (moving the tile in the grid)
    public void moveTile(int newRowIndex, int newColIndex){
	rIndex = newRowIndex;
	cIndex = newColIndex;
    }
    
    public abstract void draw(Graphics g);

}