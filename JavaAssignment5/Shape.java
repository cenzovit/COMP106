/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the abstract Shape class, which
 * will be inherited by all shapes used in the 3d Scene
 *
 */

import javax.media.j3d.*;
import javax.vecmath.*;

import com.sun.j3d.utils.geometry.*;

public abstract class Shape extends BranchGroup{
    
    protected String shape;
        
    protected TransformGroup object;
    protected Vector3d translation;
    protected double vertAngle = 0;
    protected double horzAngle = 0;
    
    protected int rotateCheck = 3;

    public String getShape(){
	return shape;
    }
    
    public void rotateVert(){
	if ((rotateCheck%3) != 2){
	    rotateCheck = 2;
	}
	else{
	    rotateCheck = 3;
	}
    }
    
    public void rotateHorz(){
	if ((rotateCheck%3) != 1){
	    rotateCheck = 1;
	}
	else{
	    rotateCheck = 3;
	}
    }
    
    public void tick(){
	if(rotateCheck != 3){
	    Transform3D trans = new Transform3D();
	    if(rotateCheck == 1){
		horzAngle += (2 * Math.PI) / 90.;
		if(horzAngle > 2*Math.PI){
		    horzAngle -= 2*Math.PI;
		}
		trans.rotX(horzAngle);
		trans.setTranslation(translation);
		object.setTransform(trans);
	    }
	    else{
		vertAngle += (2 * Math.PI) / 90.;
		if(vertAngle > 2*Math.PI){
		    vertAngle -= 2*Math.PI;
		}
		trans.rotY(vertAngle);
		trans.setTranslation(translation);
		object.setTransform(trans);
	    }
	}
    }
    
    public abstract TransformGroup objectGroup();

}