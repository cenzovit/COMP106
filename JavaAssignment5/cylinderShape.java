/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class represents the shape that will be
 * a purple cylinder.
 *
 */

import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;

import com.sun.j3d.utils.geometry.*;

public class cylinderShape extends Shape{
    
    public cylinderShape(){
	shape = "Cylinder";
	object = objectGroup();
	translation = new Vector3d();
    }
    
    public TransformGroup objectGroup(){
	Material purpleMaterial = new Material();
        purpleMaterial.setDiffuseColor(1.0f, 0.0f, 1.0f);
        purpleMaterial.setAmbientColor(1.0f, 0.0f, 1.0f);
        Appearance objectColor = new Appearance();
        objectColor.setMaterial(purpleMaterial);

	TransformGroup object = new TransformGroup();
	object.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	this.addChild(object);
	object.addChild(new Cylinder(.2f, .4f, Sphere.GENERATE_NORMALS, objectColor));
	return object;
    }
    
}