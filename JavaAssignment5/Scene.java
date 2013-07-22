/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file initializes the and maintains the
 * 3D scene.
 *
 */

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.media.j3d.*;
import javax.vecmath.*;

import com.sun.j3d.utils.geometry.*;

public class Scene extends BranchGroup implements ActionListener{
    
    private Shape shapes[][];
    
    public Scene (){
	shapes = new Shape[8][8];
	initShapes();
	
	// Main (point) light
	PointLight pointLight = new PointLight ();
	pointLight.setPosition (-10.f, 10.f, 10.f);
	pointLight.setInfluencingBounds (new BoundingSphere (new Point3d(), Float.MAX_VALUE));
	this.addChild (pointLight);

	// Ambient
	AmbientLight ambientLight = new AmbientLight ();
	ambientLight.setColor (new Color3f (0.2f, 0.2f, 0.2f));
	ambientLight.setInfluencingBounds (new BoundingSphere (new Point3d(), Float.MAX_VALUE));
	this.addChild(ambientLight);

	javax.swing.Timer timer = new javax.swing.Timer(100, this);
	timer.start();
    }
    
    private void initShapes(){
	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 8; j++){
		Transform3D translate = new Transform3D();
		translate.setTranslation(new Vector3d(i-3.5,j-3.5, -10));
		TransformGroup objTranslate = new TransformGroup(translate);
		this.addChild(objTranslate);
		shapes[i][j] = randShape();
		objTranslate.addChild(shapes[i][j]);
		
	    }
	}
    }
    
    private Shape randShape(){
	Random generator = new Random();
        int randShape = generator.nextInt(4);
        if (randShape == 0){
            return new cubeShape();
        }
        else if (randShape == 1){
            return new sphereShape();
        }
        else if (randShape == 2){
            return new coneShape();
        }
	else{
	    return new cylinderShape();
	}
    }
    
    public void rotateV(String shape){
	for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(shapes[i][j].getShape() == shape){
		    shapes[i][j].rotateVert();
		}
            }
        }
    }
    
    public void rotateH(String shape){
	for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
		if(shapes[i][j].getShape() == shape){
                    shapes[i][j].rotateHorz();
		}
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
	for(int i = 0; i < 8; i++){
	    for(int j = 0; j < 8; j++){
		Shape s = shapes[i][j];
		s.tick();
	    }
	}
    }
    
}
