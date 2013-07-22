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
    private Color colors[];

    public Board(){
	gameBoard = new Tile[8][8];
	colors = new Color[6];
	initColors();
	initTiles();
	initBoard();
    }
    
    private void initColors(){
	colors[0] = Color.RED;
	colors[1] = Color.GREEN;
	colors[2] = Color.BLUE;
	colors[3] = Color.YELLOW;
	colors[4] = Color.MAGENTA;
	colors[5] = Color.CYAN;
    }
    
    protected void randomColors(){
	changeColors(0);
    }
    
    protected void resetColors(){
	changeColors(1);
    }

    protected void newGame(){
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j < 8; j++){
		gameBoard[i][j].delete();
	    }
	}
	reDisplay();
	initColors();
	initTiles();
	initBoard();
	reDisplay();
    }
    
    protected int checkBoard(){
	int test = 0;
	int score = 0;
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j < 8; j++){
		int check = gameBoard[i][j].checkExplode();
		if(check > 0 && gameBoard[i][j].notDeleted()){
		    if(check == 3){
			explodeRow(i, j);
			explodeCol(i, j);
		    }
		    else if(check == 2){
			explodeRow(i, j);
		    }
		    else{
			explodeCol(i, j);
		    }
		    test = 1;
		}
	    }
	}
	reDisplay();
	score += removeDeleted();
	pause();
	if(test == 1){
	    score += checkBoard();
	}
	return score;
    }
    
    private void initBoard(){
	int test = 0;
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j < 8; j++){
		int check = gameBoard[i][j].checkExplode();
		if(check > 0 && gameBoard[i][j].notDeleted()){
		    if(check == 3){
			explodeRow(i, j);
			explodeCol(i, j);
		    }
		    else if(check == 2){
			explodeRow(i, j);
		    }
		    else{
			explodeCol(i, j);
		    }
		    test = 1;
		}
	    }
	}
	initRemoveDeleted();
	if(test == 1){
	    initBoard();
	}
    }
    
    protected void pause(){
	try{
	    Thread.sleep(250);
	}
	catch (InterruptedException e){
	    e.printStackTrace();
	}
    }
    
    public Tile[][] getTiles(){
	return gameBoard;
    }
    
    public Tile getTile(int colNum, int rowNum){
	return gameBoard[colNum][rowNum];
    }

    private void initSwapTiles(Tile t1, Tile t2){
	int tempx = t1.getRowIndex();
        int tempy = t1.getColIndex();
        int tempx2 = t2.getRowIndex();
        int tempy2 = t2.getColIndex();
        gameBoard[tempx][tempy] = t2;
        gameBoard[tempx2][tempy2] = t1;
        t1.moveTile(tempx2, tempy2);
        t2.moveTile(tempx, tempy);
    }
    
    protected void swapTiles(Tile t1, Tile t2){
	int tempx = t1.getRowIndex();
        int tempy = t1.getColIndex();
        int tempx2 = t2.getRowIndex();
        int tempy2 = t2.getColIndex();
        gameBoard[tempx][tempy] = t2;
        gameBoard[tempx2][tempy2] = t1;
        t1.moveTile(tempx2, tempy2);
        t2.moveTile(tempx, tempy);
	reDisplay();
    }

    private void markDeleteLeft(int colNum, int rowNum, int value){
	if(colNum >= 0){
	    if(value == gameBoard[colNum][rowNum].getValue()){
		gameBoard[colNum][rowNum].delete();
		markDeleteLeft(colNum - 1, rowNum, value);
	    }
	}
    }
    
    private void markDeleteRight(int colNum, int rowNum, int value){
	if(colNum <= 7){
	    if(value == gameBoard[colNum][rowNum].getValue()){
		gameBoard[colNum][rowNum].delete();
		markDeleteRight(colNum + 1, rowNum, value);
	    }
	}
    }
    
    private void markDeleteUp(int colNum, int rowNum, int value){
	if(rowNum >= 0){
	    if(value == gameBoard[colNum][rowNum].getValue()){
		gameBoard[colNum][rowNum].delete();
		markDeleteUp(colNum, rowNum - 1, value);
	    }
	}
    }
    
    private void markDeleteDown(int colNum, int rowNum, int value){
	if(rowNum <= 7){
	    if(value == gameBoard[colNum][rowNum].getValue()){
		gameBoard[colNum][rowNum].delete();
		markDeleteDown(colNum, rowNum + 1, value);
	    }
	}
    }
    
    protected void explodeRow(int colNum, int rowNum){
	Tile t1 = gameBoard[colNum][rowNum];
	int value = t1.getValue();
	t1.delete();
	markDeleteLeft(colNum - 1, rowNum, value);
	markDeleteRight(colNum + 1, rowNum, value);
    }
        
    protected void explodeCol(int colNum, int rowNum){
	Tile t1 = gameBoard[colNum][rowNum];
	int value = t1.getValue();
	t1.delete();
	markDeleteUp(colNum, rowNum - 1, value);
	markDeleteDown(colNum, rowNum + 1, value);
    }

    private void initRemoveDeleted(){
	int numDeletedInRow[][] = new int[2][8];
	for(int row = 0; row < 8; row++){
	    numDeletedInRow[0][row] = 0;
	    numDeletedInRow[1][row] = 0;
	}
	for(int row = 0; row < 8; row++){
	    for(int col = 0; col < 8; col++){
		if(gameBoard[col][row].isDeleted()){
		    numDeletedInRow[0][row] += 1;
		    numDeletedInRow[1][row] = col;
		}
	    }
	}
	for(int row = 0; row < 8; row++){
	    if (numDeletedInRow[0][row] > 0){
		initDropColumns(numDeletedInRow[0][row], numDeletedInRow[1][row], row);
	    }
	}
    }
    
    protected int removeDeleted(){
	pause();
	int score = 0;
	int numDeletedInRow[][] = new int[2][8];
	for(int row = 0; row < 8; row++){
	    numDeletedInRow[0][row] = 0;
	    numDeletedInRow[1][row] = 0;
	}
	for(int row = 0; row < 8; row++){
	    for(int col = 0; col < 8; col++){
		if(gameBoard[col][row].isDeleted()){
		    numDeletedInRow[0][row] += 1;
		    numDeletedInRow[1][row] = col;
		}
	    }
	}
	for(int row = 0; row < 8; row++){
	    if (numDeletedInRow[0][row] > 0){
		dropColumns(numDeletedInRow[0][row], numDeletedInRow[1][row], row);
		score += numDeletedInRow[0][row];
	    }
	}
	pause();
	return score;
    }

    private void initDropColumns(int numTimes, int colNum, int rowNum){
	int row = rowNum;
	while(row > 0){
	    for(int col = colNum; col > (colNum - numTimes); col--){
		Tile t1 = gameBoard[col][row];
		Tile t2 = gameBoard[col][row-1];
		initSwapTiles(t1, t2);
	    }
	    row -= 1;
	}
	for(int col = colNum; col > (colNum - numTimes); col--){
	    gameBoard[col][row] = randomTile(col, row);
	}
    }
    
    private void dropColumns(int numTimes, int colNum, int rowNum){
	int row = rowNum;
	while(row > 0){
	    for(int col = colNum; col > (colNum - numTimes); col--){
		Tile t1 = gameBoard[col][row];
		Tile t2 = gameBoard[col][row-1];
		swapTiles(t1, t2);
	    }
	    if(numTimes > 1){
		pause();
	    }
	    row -= 1;
	}
	for(int col = colNum; col > (colNum - numTimes); col--){
	    gameBoard[col][row] = randomTile(col, row);
	}
	reDisplay();
	pause();
    }
    
    protected void reDisplay(){
	super.paintImmediately(0,0,super.getWidth(),super.getHeight());
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

    public void changeColors(int check){
	if (check == 0){
	    initRandomColors();
	    for(int i = 0; i < 8; i++){
		for(int j = 0; j < 8; j++){
		    Tile temp = gameBoard[i][j];
		    int value = temp.getValue();
		    temp.setColor(colors[value]);
		}
	    }
	}
	else{
	    initColors();
	    for(int i = 0; i < 8; i++){
		for(int j = 0; j < 8; j++){
		    Tile temp = gameBoard[i][j];
		    int value = temp.getValue();
		    temp.setColor(colors[value]);
		}
	    }
	}
	reDisplay();
    }
    
    private void initRandomColors(){
	Random generator = new Random();
	colors[0] = new Color(generator.nextInt(100), generator.nextInt(100), generator.nextInt(255));
	colors[1] = new Color(generator.nextInt(100), generator.nextInt(255), generator.nextInt(100));
	colors[2] = new Color(generator.nextInt(255), generator.nextInt(100), generator.nextInt(100));
	colors[3] = new Color(generator.nextInt(100), generator.nextInt(255), generator.nextInt(255));
	colors[4] = new Color(generator.nextInt(255), generator.nextInt(100), generator.nextInt(255));
	colors[5] = new Color(generator.nextInt(255), generator.nextInt(255), generator.nextInt(100));
	
    }
    
    private Tile randomTile(int xInd, int yInd){
	Random generator = new Random();
	int randTile = generator.nextInt(6);
	if (randTile == 0){
	    return new rectangleZeroTile(xInd, yInd, colors[0], this);
	}
	else if (randTile == 1){
	    return new triangleOneTile(xInd, yInd, colors[1], this);
	}
	else if (randTile == 2){
	    return new circleTwoTile(xInd, yInd, colors[2], this);
	}
	else if (randTile == 3){
	    return new rectangleThreeTile(xInd, yInd, colors[3], this);
	}
	else if (randTile == 4){
	    return new triangleFourTile(xInd, yInd, colors[4], this);
	}
	else{
	    return new circleFiveTile(xInd, yInd, colors[5], this);
	}
    }
}