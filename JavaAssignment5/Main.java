/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the main routine of my program
 *
 */


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.Object.*;


import javax.media.j3d.*;
import javax.vecmath.*;

import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.behaviors.keyboard.*;
import com.sun.j3d.utils.behaviors.vp.*;
import com.sun.j3d.utils.geometry.*;

public class Main extends JFrame {
    
    public static void main (String[] args) {
	new Main ();
    }

    public Main(){
	
	setSize (600, 800);
	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	Canvas3D canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
	SimpleUniverse universe = new SimpleUniverse (canvas3D);
	Scene scene = new Scene();
	addKbdNavig (universe, scene);

	scene.compile ();
	universe.addBranchGraph (scene);
    
	Container content = getContentPane();
	content.setLayout (new BorderLayout());
	content.add (canvas3D, BorderLayout.CENTER);
	
	//create the control panel        
	guiControlPanel controls = new guiControlPanel(scene);
        	
	//add control panel to the content container
        content.add(controls, BorderLayout.SOUTH);
	
	setVisible (true);
    }

    /*
     * Set things up for keyboard navigation,
     * for your universe and scene.
     * Built-in class, uses arrow keys, pgup/pgdn, +, -, and =
     * also Alt-left/right arrow, Alt-pgup/pgdn
     */
    private void addKbdNavig (SimpleUniverse universe, BranchGroup scene) {
	KeyNavigatorBehavior kbdBehavior = new KeyNavigatorBehavior(universe.getViewingPlatform().getViewPlatformTransform());
	kbdBehavior.setSchedulingBounds(new BoundingSphere (new Point3d(), Float.MAX_VALUE));
	scene.addChild(kbdBehavior);
    }
}