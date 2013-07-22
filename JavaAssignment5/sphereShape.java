/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class represents the shape which will be
 * a blue sphere. 
 *
 */


import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;

import com.sun.j3d.utils.geometry.*;

public class sphereShape extends Shape{
    
    public sphereShape(){
	shape = "Sphere";
	object = objectGroup();
	translation = new Vector3d();
    }
    
    public TransformGroup objectGroup(){
	Material blueMaterial = new Material();
        blueMaterial.setDiffuseColor(0.0f, 0.0f, 1.0f);
        blueMaterial.setAmbientColor(0.0f, 0.0f, 1.0f);
        Appearance objectColor = new Appearance();
        objectColor.setMaterial(blueMaterial);

	//Appearance objectColor = new Appearance();
	//objectColor.setColoringAttributes(Color3f(Color.BLUE), ColoringAttributes.FASTEST);

	TransformGroup object = new TransformGroup();
	object.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	this.addChild(object);
	object.addChild(new Sphere(.2f, Sphere.GENERATE_NORMALS, objectColor));
	return object;
    }
    
}