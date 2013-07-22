/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the Game functionality.
 * It extends board, allowing it access to the
 * game's visual components whose information
 * can be used to properly implement the 
 * MouseListener, allowing user interaction.
 *
 * In the future, the game class will track the
 * score and time, and implement functions which
 * will observe whether to "explode" tiles or 
 * not. Hopefully, this will further extend to 
 * create more intricate tiles as seen in the 
 * real Bejeweled by PopCap.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.lang.*;

public class Game extends Board implements MouseInputListener {

    private int score;
    private int test;
    private Tile firstSelected;
    
    public Game(){
	super();
	score = 0;
	test = 0; 
	addMouseListener(this);
	addMouseMotionListener(this);
    }

    public int getScore(){
	return score;
    }

    public void paintComponent(Graphics g){
	super.paintComponent(g);
    }

    public void swapTiles(Tile t1, Tile t2, Tile[][] gb){
	int tempx = t1.getRowIndex();
	int tempy = t1.getColIndex();
	int tempx2 = t2.getRowIndex();
	int tempy2 = t2.getColIndex();
	gb[tempx][tempy] = t2;
	gb[tempx2][tempy2] = t1;
	t1.moveTile(tempx2, tempy2);
	t2.moveTile(tempx, tempy);
    }
    
    public void mouseClicked(MouseEvent e){
	Tile[][] temp = getTiles();
	int xLoc = e.getX();
	int yLoc = e.getY();
	int tileXLoc = xLoc / (super.getWidth()/8);
	int tileYLoc = yLoc / (super.getHeight()/8);
	Tile select = temp[tileXLoc][tileYLoc];
	if (test == 0){
	    select.setSelected(true);
	    firstSelected = select;
	    test = 1;
	}
	else if (firstSelected == select){
	    select.setSelected(false);
	    test = 0;
	}
	else if (firstSelected.getRowIndex() == select.getRowIndex()){
	    if((firstSelected.getColIndex() == select.getColIndex() - 1) || (firstSelected.getColIndex() == select.getColIndex() + 1)){
		firstSelected.setSelected(false);
		swapTiles(firstSelected, select, temp);
		test = 0;
	    }
	    else{
		select.setSelected(true);
		firstSelected.setSelected(false);
		firstSelected = select;
	    }
	}
	else if (firstSelected.getColIndex() == select.getColIndex()){
	    if((firstSelected.getRowIndex() == select.getRowIndex() - 1) || (firstSelected.getRowIndex() == select.getRowIndex() +1)){
		firstSelected.setSelected(false);
		swapTiles(firstSelected, select, temp);
		test = 0;
	    }
	    else{
		select.setSelected(true);
		firstSelected.setSelected(false);
		firstSelected = select;
	    }
	}
	else{
	    select.setSelected(true);
	    firstSelected.setSelected(false);
	    firstSelected = select;
	}
	repaint();
    }    

    //MouseInputListener(MouseListener+MouseMotionListener) defines all of these, so we must supply them
    public void mouseMoved(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}



}
