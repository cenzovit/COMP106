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
    private int numMoves;
    private int numValidMoves;
    private int test;
    private Tile firstSelected;
    private JPanel states;
    
    public Game(JPanel _states){
	super();
	score = 0;
	test = 0;
	numMoves = 0;
	numValidMoves = 0;
	states = _states;
	updateStates();
	addMouseListener(this);
	addMouseMotionListener(this);
    }
    
    protected void newGame(){
	super.newGame();
	score = 0;
	test = 0;
	numMoves = 0;
	numValidMoves = 0;
	updateStates();
    }
    
    private void updateStates(){
	states.removeAll();
	states.updateUI();
	JLabel scoreLabel = new JLabel();
	JLabel numMovesLabel = new JLabel();
	JLabel numValidMovesLabel = new JLabel();
        scoreLabel.setText("Score: " + score*10 + "  ");
	numMovesLabel.setText("Number of Attempted Moves: " + numMoves + "  ");
	numValidMovesLabel.setText("Number of Valid Moves: " + numValidMoves + "  ");
        states.add(scoreLabel);
	states.add(numMovesLabel);
	states.add(numValidMovesLabel);
	states.validate();
    }

    public int getScore(){
	return score;
    }

    public void paintComponent(Graphics g){
	super.paintComponent(g);
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
		numMoves += 1;
		swapTiles(firstSelected, select);
		pause();
		int fSCE = firstSelected.checkExplode();
		int sCE = select.checkExplode();
		if(fSCE == 0 && sCE == 0){
		    swapTiles(firstSelected, select);
		    pause();
		}
		else{
		    numValidMoves += 1;
		    if(fSCE == 3){
			explodeRow(firstSelected.getRowIndex(), firstSelected.getColIndex());
			explodeCol(firstSelected.getRowIndex(), firstSelected.getColIndex());
		    }
		    else if(fSCE == 2){
			explodeRow(firstSelected.getRowIndex(), firstSelected.getColIndex());
		    }
		    else if(fSCE == 1){
			explodeCol(firstSelected.getRowIndex(), firstSelected.getColIndex());			
		    }
		    if(sCE == 3){
			explodeRow(select.getRowIndex(), select.getColIndex());
			explodeCol(select.getRowIndex(), select.getColIndex());
		    }
		    else if(sCE == 2){
			explodeRow(select.getRowIndex(), select.getColIndex());
		    }
		    else if(sCE == 1){
			explodeCol(select.getRowIndex(), select.getColIndex());			
		    }
		    reDisplay();
		    pause();
		    score += removeDeleted();
		    score += checkBoard();
		}
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
		numMoves += 1;
		swapTiles(firstSelected, select);
		pause();
		int fSCE = firstSelected.checkExplode();
		int sCE = select.checkExplode();
		if(fSCE == 0 && sCE == 0){
		    swapTiles(firstSelected, select);
		    pause();
		}
		else{
		    numValidMoves += 1;
		    if(fSCE == 3){
			explodeRow(firstSelected.getRowIndex(), firstSelected.getColIndex());
			explodeCol(firstSelected.getRowIndex(), firstSelected.getColIndex());
		    }
		    else if(fSCE == 2){
			explodeRow(firstSelected.getRowIndex(), firstSelected.getColIndex());
		    }
		    else if(fSCE == 1){
			explodeCol(firstSelected.getRowIndex(), firstSelected.getColIndex());			
		    }
		    if(sCE == 3){
			explodeRow(select.getRowIndex(), select.getColIndex());
			explodeCol(select.getRowIndex(), select.getColIndex());
		    }
		    else if(sCE == 2){
			explodeRow(select.getRowIndex(), select.getColIndex());
		    }
		    else if(sCE == 1){
			explodeCol(select.getRowIndex(), select.getColIndex());			
		    }
		    reDisplay();
		    pause();
		    score += removeDeleted();
		    score += checkBoard();
		}
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
	updateStates();
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
