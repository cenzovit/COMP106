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
  protected int xLoc, yLoc, mWidth, mHeight;
  private Color normCol, selectCol;
  private boolean highlighted, selected, notDeleted;
  private int value;
  private int moved;

  public Tile(int _rIndex, int _cIndex, Color _col, Board _gameBoard, int _value){
    gameBoard = _gameBoard;
    updateInfo();
    rIndex = _rIndex;
    cIndex = _cIndex;
    normCol = _col;
    selectCol = _col.darker();
    highlighted = false;
    selected = false;
    notDeleted = true;
    value = _value;
  }

  public int getValue(){
    return value;
  }

  public String getShape(){
    if (value == 0){
      return "Rectangle";
    }
    else if (value == 1){
      return "Triangle";
    }
    else if (value == 2){
      return "Circle";
    }
    else if (value == 3){
      return "Diamond";
    }
    else if (value == 4){
      return "Pentagon";
    }
    else{
      return "Octagon";
    }
  }

  public void moved(){
    moved += 1;
  }

  public int getMoved(){
    return moved;
  }

  public void setColor(Color col){
    normCol = col;
    selectCol = col.darker();
  }

  public void delete(){
    notDeleted = false;
  }

  public boolean notDeleted(){
    return notDeleted;
  }

  public boolean isDeleted(){
    return !(notDeleted);
  }

  private int checkChainLeft(){
    if(rIndex == 0){
      return 0;
    }
    else{
      int test = 0;
      int colToCheck = rIndex - 1;
      int chain = 0;
      while(test == 0 && colToCheck >= 0){
        test = 1;
        if(value == gameBoard.getTile(colToCheck, cIndex).getValue()){
          chain += 1;
          test = 0;
          colToCheck -= 1;
        }
      }
      return chain;
    }
  }

  private int checkChainRight(){
    if(rIndex == 7){
      return 0;
    }
    else{
      int test = 0;
      int colToCheck = rIndex + 1;
      int chain = 0;
      while(test == 0 && colToCheck <= 7){
        test = 1;
        if(value == gameBoard.getTile(colToCheck, cIndex).getValue()){
          chain += 1;
          test = 0;
          colToCheck += 1;
        }
      }
      return chain;
    }
  }

  private int checkChainUp(){
    if(cIndex == 0){
      return 0;
    }
    else{
      int test = 0;
      int rowToCheck = cIndex - 1;
      int chain = 0;
      while(test == 0 && rowToCheck >= 0){
        test = 1;
        if(value == gameBoard.getTile(rIndex, rowToCheck).getValue()){
          chain += 1;
          test = 0;
          rowToCheck -= 1;
        }
      }
      return chain;
    }
  }

  private int checkChainDown(){
    if(cIndex == 7){
      return 0;
    }
    else{
      int test = 0;
      int rowToCheck = cIndex + 1;
      int chain = 0;
      while(test == 0 && rowToCheck <= 7){
        test = 1;
        if(value == gameBoard.getTile(rIndex, rowToCheck).getValue()){
          chain += 1;
          test = 0;
          rowToCheck += 1;
        }
      }
      return chain;
    }
  }

  private boolean checkExplodeCol(){
    int chain = 1;
    chain += checkChainUp();
    chain += checkChainDown();
    if(chain >= 3){
      return true;
    }
    else{
      return false;
    }
  }

  private boolean checkExplodeRow(){
    int chain = 1;
    chain += checkChainLeft();
    chain += checkChainRight();
    if(chain >= 3){
      return true;
    }
    else{
      return false;
    }
  }

  public int checkExplode(){
    if(checkExplodeCol() && checkExplodeRow()){
      return 3;
    }
    else if(checkExplodeCol()){
      return 1;
    }
    else if(checkExplodeRow()){
      return 2;
    }
    else{
      return 0;
    }
  }

  public void updateInfo(){
    int gridWidth = gameBoard.getWidth()/8;
    int gridHeight = gameBoard.getHeight()/8;
    xLoc = (rIndex*gridWidth) + 10;
    yLoc = (cIndex*gridHeight) + 10;
    mWidth = gridWidth - 20;
    mHeight = gridHeight - 20;
  }

  public Color getColor(){
    return normCol;
  }

  public Color getSelectedColor(){
    return selectCol;
  }

  public int getRow(){
    return cIndex;
  }

  public int getCol(){
    return rIndex;
  }

  public int getRowIndex(){
    return rIndex;
  }

  public int getColIndex(){
    return cIndex;
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
    moved += 1;
  }

  public abstract void draw(Graphics g);

}
