/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the class which represents
 * the gui controls JPanel.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.Object.*;

public class guiControlPanel extends JPanel {
    
    private Scene scene;
    private String currShape;
    
    public guiControlPanel(Scene _scene){
	super();
	scene = _scene;
	currShape = "Cube";
	initPanel();
    }

    public String getCurrShape(){
	return currShape;
    }
    
    public void changeShape(String _newShape){
	currShape = _newShape;
    }
    
    public void initPanel(){
	this.setBorder(new LineBorder(Color.black, 2));
	this.setLayout(new BorderLayout());
	
	//Create Tab Contents
	JPanel rotateTab = createRotateTab();
	//JPanel colorTab = createColorTab();
	JPanel exitTab = createExitTab();
	
	//Layout the content 
	Border padding = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	rotateTab.setBorder(padding);
	//colorTab.setBorder(padding);
	exitTab.setBorder(padding);
	
	JTabbedPane tabbedPane = new JTabbedPane();
	tabbedPane.addTab("Rotation Control", rotateTab);
	//tabbedPane.addTab("Color Control", colorTab);
	tabbedPane.addTab("Other Options", exitTab);
	this.add(tabbedPane, BorderLayout.CENTER);
    }
    
    private JPanel createRotateTab(){
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(2,2));
	JLabel shapeLabel = new JLabel();
	shapeLabel.setText("[Select Shape]");
	shapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
	shapeComboBox shapeBox = new shapeComboBox(this);
	rotateHButton horizButton = new rotateHButton(scene, this);
	rotateVButton vertiButton = new rotateVButton(scene, this);
	panel.add(shapeLabel);
	panel.add(vertiButton);
	panel.add(shapeBox);
	panel.add(horizButton);
	return panel;
    }

    private JPanel createExitTab(){
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(1,1));
	quitButton b1 = new quitButton();
	panel.add(b1);
	return panel;
    }
   
    
}