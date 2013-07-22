/* Vincenzo Vitiello
 * cenzo.vit@gmail.com
 *
 * This file contains the class which represents
 * the gui JPanel when a tile is selected.
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.lang.Object.*;

public class guiControlPanel extends JPanel {

  private Tile selectedTile;
  private Container frame;
  private Game gB;
  private int test;

  public guiControlPanel(Container _frame, Game _gB){
    frame = _frame;
    gB = _gB;
    test = 0;
    update();
  }

  public void update(){
    //if(test == 0){
    this.removeAll();
    this.updateUI();
    this.setBorder(new LineBorder(Color.black, 2));
    this.setLayout(new FlowLayout());
    newGameButton b1 = new newGameButton(gB);
    resetColorsButton b2 = new resetColorsButton(gB);
    randomColorsButton b3 = new randomColorsButton(gB);
    quitButton b4 = new quitButton();
    this.add(b1);
    this.add(b2);
    this.add(b3);
    this.add(b4);
    this.validate();
    test = 1;
    //}
  }

  public void update(Tile selectedTile){
    //if(test == 1){

    this.removeAll();
    this.updateUI();
    this.setBorder(new LineBorder(Color.black, 2));
    this.setLayout(new BorderLayout());

    //Create Tab Contents
    JPanel infoTab = createTileInfoTab(selectedTile);
    JPanel historyTab = createTileHistoryTab(selectedTile);
    JPanel colorTab = createTileColorTab(selectedTile);
    JPanel shapeTab = createTileShapeTab(selectedTile);

    //Layout the content 
    Border padding = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    infoTab.setBorder(padding);
    historyTab.setBorder(padding);
    colorTab.setBorder(padding);
    shapeTab.setBorder(padding);

    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.addTab("Information", infoTab);
    tabbedPane.addTab("History", historyTab);
    tabbedPane.addTab("Color", colorTab);
    tabbedPane.addTab("Shape", shapeTab);
    this.add(tabbedPane, BorderLayout.CENTER);
    this.validate();
    test = 0;

    //}
  }

  private JPanel createTileInfoTab(Tile selectedTile){
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1,3));
    JLabel rowLabel = new JLabel();
    JLabel colLabel = new JLabel();
    JLabel shapeLabel = new JLabel();
    rowLabel.setText("Row Number: " + selectedTile.getRow());
    colLabel.setText("Column Number: " + selectedTile.getCol()); 
    shapeLabel.setText("Shape: " + selectedTile.getShape()); 
    rowLabel.setHorizontalAlignment(SwingConstants.CENTER);
    colLabel.setHorizontalAlignment(SwingConstants.CENTER);
    shapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(rowLabel);
    panel.add(colLabel);
    panel.add(shapeLabel);
    return panel;
  }

  private JPanel createTileHistoryTab(Tile selectedTile){
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(1,1));
    JLabel label = new JLabel();
    label.setText("Total Times the Tile has Moved: " + selectedTile.getMoved());
    label.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(label);
    return panel;
  }

  private JPanel createTileColorTab(Tile selectedTile){
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2,3));	
    JLabel redLabel = new JLabel();
    JLabel greenLabel = new JLabel();
    JLabel blueLabel = new JLabel();
    redLabel.setText("[Red Value]");
    greenLabel.setText("[Green Value]");
    blueLabel.setText("[Blue Value]");
    redLabel.setHorizontalAlignment(SwingConstants.CENTER);
    greenLabel.setHorizontalAlignment(SwingConstants.CENTER);
    blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
    colorSlider redSlider = new colorSlider(selectedTile, gB, 1);
    colorSlider greenSlider = new colorSlider(selectedTile, gB, 2);
    colorSlider blueSlider = new colorSlider(selectedTile, gB, 3);
    panel.add(redLabel);
    panel.add(greenLabel);
    panel.add(blueLabel);
    panel.add(redSlider);
    panel.add(greenSlider);
    panel.add(blueSlider);
    return panel;
  }

  private JPanel createTileShapeTab(Tile selectedTile){
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2,2));
    shapeComboBox shapeBox = new shapeComboBox(selectedTile, gB);
    JLabel currShapeLabel = new JLabel();
    JLabel currShape = new JLabel();
    JLabel changeToLabel = new JLabel();
    currShapeLabel.setText("[Current Shape]");
    currShape.setText(selectedTile.getShape());
    changeToLabel.setText("[Change Shape To]");
    currShapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    currShape.setHorizontalAlignment(SwingConstants.CENTER);
    changeToLabel.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(currShapeLabel);
    panel.add(changeToLabel);
    panel.add(currShape);
    panel.add(shapeBox);
    return panel;
  }


}
