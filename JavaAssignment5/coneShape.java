/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This class represents the shape that will
 * be a green Cone.
 *
 */


import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;

import com.sun.j3d.utils.geometry.*;

public class coneShape extends Shape{
    
    public coneShape(){
	shape = "Cone";
	object = objectGroup();
	translation = new Vector3d();
    }
    
    public TransformGroup objectGroup(){
	Material greenMaterial = new Material();
        greenMaterial.setDiffuseColor(0.0f, 1.0f, 0.0f);
        greenMaterial.setAmbientColor(0.0f, 1.0f, 0.0f);
        Appearance objectColor = new Appearance();
        objectColor.setMaterial(greenMaterial);

	//Appearance objectColor = new Appearance();
	//objectColor.setColoringAttributes(Color3f(Color.GREEN), ColoringAttributes.FASTEST);

	TransformGroup object = new TransformGroup();
	object.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
	this.addChild(object);
	object.addChild(new Cone(.2f, .2f, Cone.GENERATE_NORMALS, objectColor));
	return object;
    }
    
}