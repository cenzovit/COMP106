/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class represents the shape which will be
 * a red cube.
 *
 */

import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;

import com.sun.j3d.utils.geometry.*;

public class cubeShape extends Shape{
    
    public cubeShape(){
	shape = "Cube";
	object = objectGroup();
	translation = new Vector3d();
    }
    
    public TransformGroup objectGroup(){
	Material redMaterial = new Material();
	redMaterial.setDiffuseColor(1.0f, 0.0f, 0.0f);
	redMaterial.setAmbientColor(1.0f, 0.0f, 0.0f);
	Appearance objectColor = new Appearance();
	objectColor.setMaterial(redMaterial);
	
	//Appearance objectColor = new Appearance();
	//objectColor.setColoringAttributes(Color3f(Color.RED), ColoringAttributes.FASTEST);

	TransformGroup object = new TransformGroup();
	object.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	this.addChild(object);
	object.addChild(new Box(.2f, .2f, .2f, Box.GENERATE_NORMALS, objectColor));
	return object;
    }
    
}