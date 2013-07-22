/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 * 
 * This file contains the code for the Drawing Area of my program.
 * The drawing area allows the user to create either rectangles
 * or ovals by clicking and dragging the mouse in the canvas.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.Math.*;
import java.util.*;

public class drawArea extends JComponent implements MouseInputListener{
    private int x1, y1, x2, y2;
    private int wShape;
    private int newShapeComplete;
    //vector to contain drawn rectangles
    private Vector<Object> mRects;
    //vector to contain drawn circles
    private Vector<Object> mCircs;

    drawArea(){
	x1 = 0;
	y1 = 0;
	x2 = 0;
	y2 = 0;
	newShapeComplete = 0;
	wShape = 0;
	mRects = new Vector<Object>();
	mCircs = new Vector<Object>();
	addMouseListener(this);
	addMouseMotionListener(this);
    }

    //method to allow widgets to set which shape is being made
    public void setShape(int shapeNum){
	wShape = shapeNum;
    }

    //method to allow widgets to clear all shapes that have been made
    public void removeShapes(){
	mRects.clear();
	mCircs.clear();
	repaint();
    }

    //method which draws all the rects and ovals found in the mRects
    // and mCircs vectors.
    public void paintComponent(Graphics g){
	super.paintComponents(g);
	for(int i = 0; i < mRects.size(); i++){
	    Rectangle currRect = (Rectangle)mRects.elementAt(i);
	    g.drawRect((int)currRect.getX(), (int)currRect.getY(), 
		       (int)currRect.getWidth(), (int)currRect.getHeight());
	} 
	for(int i = 0; i < mCircs.size(); i++){
	    //since an oval is merely an oval drawn to fit in a rectangle,
	    // I store oval data as the rectangle that contains it.
	    Rectangle currCirc = (Rectangle)mCircs.elementAt(i);
	    g.drawOval((int)currCirc.getX(), (int)currCirc.getY(), 
		       (int)currCirc.getWidth(), (int)currCirc.getHeight());
	}
    }

    //method which creates the shapes
    private void mCreateShape(){
	int width = x1 - x2;
	int height = y1 - y2;
	//determines the x and y components of the top corner based upon
	// the x and y values of the two given points that form the rect.
	int rectX = width < 0 ? x1 : x2;
	int rectY = height < 0 ? y1 : y2;
	width = Math.abs(width);
	height = Math.abs(height);
	Rectangle newShape = new Rectangle(rectX, rectY, width, height);
	//check whether a new rectangle or a new oval is being created
	if (wShape == 0){
	    //if the mouse is being dragged we remove the shape that is being 
	    // created so that we can update its shape based on the mouse
	    // movement.
	    if (newShapeComplete == 0 && mRects.size() > 0){
		mRects.removeElementAt(mRects.size()-1); 
	    }
	    mRects.add(newShape);
	}
	else if (wShape == 1){
	    if (newShapeComplete == 0 && mCircs.size() > 0){
                mCircs.removeElementAt(mCircs.size()-1);
            }
            mCircs.add(newShape);
	}
	else{
	    System.out.println("Unknown value for wShape: " + wShape);
	}
    }
    
    //when the mouse is pressed, begin creating a new shape    
    public void mousePressed(MouseEvent e){
	x1 = e.getX();
	y1 = e.getY();
	x2 = e.getX()+1;
	y2 = e.getY()+1;
	mCreateShape();
	repaint();
	//shape is not complete until the mouse is released
	newShapeComplete = 0;
    }

    public void mouseDragged(MouseEvent e){
	updateLoc(e);
    }

    public void mouseReleased(MouseEvent e){
	newShapeComplete = 1;
	updateLoc(e);
    }

    private void updateLoc(MouseEvent e){
	x2 = e.getX();
	y2 = e.getY();
	mCreateShape();
	repaint();
    }

    // MouseInputListener(MouseListener+MouseMotionListener) defines all of these, so we must supply them
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
}