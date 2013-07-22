/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class contains the board which will
 * draw the checkered background as well as
 * store and draw an 8x8 grid of tiles. The
 * tiles will be stored in a two dimensional
 * tile array.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Board extends JComponent {

    private Tile gameBoard[][];

    public Board(){
	gameBoard = new Tile[8][8];
	initTiles();
    }
    
    public Tile[][] getTiles(){
	return gameBoard;
    }
    
    public void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	int gridWidth = getWidth()/8;
	int gridHeight = getHeight()/8;
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j < 8; j++){
		if(i%2 == j%2){
		    g2.setColor(Color.LIGHT_GRAY);
		}
		else{
	            g2.setColor(Color.GRAY);
		}
		g2.fill(new Rectangle(gridWidth*i, gridHeight*j, gridWidth, gridHeight));
		if(gameBoard[i][j].getSelected()){
		    g2.setColor(Color.RED);
		    g2.draw(new Rectangle(gridWidth*i + 5, gridHeight*j + 5, gridWidth - 10, gridHeight - 10));
		}
		gameBoard[i][j].draw(g);
	    }
	}
    }
    
    private void initTiles(){
	for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
		gameBoard[i][j] = randomTile(i, j);
	    }
	}
    }
    
    private Tile randomTile(int xInd, int yInd){
	Random generator = new Random();
	int randTile = generator.nextInt(3);
	if (randTile == 0){
	    return new redRectangleTile(xInd, yInd, this);
	}
	else if (randTile == 1){
	    return new greenTriangleTile(xInd, yInd, this);
	}
	else{
	    return new blueCircleTile(xInd, yInd, this);
	}
	
    }
    



}