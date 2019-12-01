package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import model.Building;

public class HudSCPanel extends JPanel {
	private Controller controller;
	

	private JButton buy, test, buildH, buildF, buildL, buildM, buildC, buildFarm, upgrade;
	
	 
	public HudSCPanel(Controller controller) {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		 
		this.controller = controller;
		
		setBackground(new Color(100,100,100));

 		gbc.insets = new Insets(5,5,5,5);
 		
 		test = new JButton("CE BOUTON EST A CHANGER");
 		test.setPreferredSize(new Dimension(922,148));
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(test, gbc);
 		
 		buy = new JButton("BUY");
 		buy.setPreferredSize(new Dimension(922,148));
 		buy.addActionListener(controller);
 		buy.setVisible(false);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(buy, gbc);
 		
 		upgrade = new JButton("UPGRADE");
 		upgrade.setPreferredSize(new Dimension(922,148));
 		upgrade.addActionListener(controller);
 		upgrade.setVisible(false);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(upgrade, gbc);
 		
 		buildH = new JButton("BUILD House");
 		buildH.setPreferredSize(new Dimension(415,158));
 		buildH.addActionListener(controller);
 		buildH.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 1;
 		add(buildH, gbc);
 		
 		buildFarm = new JButton("BUILD Farm");
 		buildFarm.setPreferredSize(new Dimension(415,158));
 		buildFarm.addActionListener(controller);
 		buildFarm.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
 		gbc.gridx = 2;
 		gbc.gridy = 0;
 		gbc.gridheight = 1;
 		add(buildFarm, gbc);
 		
 		buildC = new JButton("BUILD City Hall");
 		buildC.setPreferredSize(new Dimension(831,158));
 		buildC.addActionListener(controller);
 		buildC.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(buildC, gbc);
 		
 		buildF = new JButton("BUILD Fishing");
 		buildF.setPreferredSize(new Dimension(831,158));
 		buildF.addActionListener(controller);
 		buildF.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(buildF, gbc);
 		
 		buildL = new JButton("BUILD Logging");
 		buildL.setPreferredSize(new Dimension(831,158));
 		buildL.addActionListener(controller);
 		buildL.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(buildL, gbc);
 		
 		buildM = new JButton("BUILD Mine");
 		buildM.setPreferredSize(new Dimension(831,158));
 		buildM.addActionListener(controller);
 		buildM.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(buildM, gbc);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image borderL = null, textTest = null;
		try {
			borderL = ImageIO.read(new File("Graphismes/BorderSL.png"));
			textTest = ImageIO.read(new File("Graphismes/textTest.png"));
		} catch (Exception e) {}
		g.drawImage(borderL, 0, 0, this);
		//g.drawImage(textTest, 10, 20, this);
	}
		
	public void display(boolean adjacent, String typeCase, boolean cityHall, int[] ressources) {
		test.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		upgrade.setVisible(false);
		
		if(( (controller.isFirstBuy() && typeCase.equals("model.Plain")) || (adjacent && cityHall) ) && ressources[0] >= 6) {
			buy.setEnabled(true);
		}
		else {
			buy.setEnabled(false);
		}
		
		buy.setVisible(true);
		
		repaint();
	}
	//Pas utilisé mais plus peut-être oui
	/*
	public void done() {
		test.setVisible(true);
		
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		
		repaint();
	}*/
	
	private void displayUpgrade() {
		test.setVisible(false);
		
		buy.setVisible(false);
		
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildH.setVisible(false);
		buildFarm.setVisible(false);
		buildC.setVisible(false);
		
		upgrade.setVisible(true);
		upgrade.setEnabled(true);
		
		repaint();
	}
	
	public void displayPlainCityHall(int[] ressources, Building building) {
		test.setVisible(false);
		
		buy.setVisible(false);
		
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildH.setVisible(false);
		buildFarm.setVisible(false);
		upgrade.setVisible(false);
		
		buildC.setVisible(true);
		
		if(building == null) {
			if(ressources[0] >= 50 && ressources[2] >= 30) {
				buildC.setEnabled(true);
			}
			else {
				buildC.setEnabled(false);
			}
		}
		else {
			buildC.setVisible(false);
			upgrade.setVisible(true);
		}
		
		repaint();
	}

	public void displayPlain(int[] ressources, Building building) {
		test.setVisible(false);
		
		buy.setVisible(false);
		
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		upgrade.setVisible(false);
		
		buildH.setVisible(true);
		buildFarm.setVisible(true);
		
		if(building == null) {
			if(ressources[0] >= 3 && ressources[2] >= 5) {
				buildH.setEnabled(true);
			}
			else {
				buildH.setEnabled(false);
			}
			if(ressources[0] >= 3 && ressources[2] >= 5) {
				buildFarm.setEnabled(true);
			}
			else {
				buildFarm.setEnabled(false);
			}	
		}
		else {
			buildH.setVisible(false);
			buildFarm.setVisible(false);
			upgrade.setVisible(true);
		}
		
		repaint();
	}

	public void displayForest(int[] ressources, Building building) {
		test.setVisible(false);
		
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		upgrade.setVisible(false);
		
		buildL.setVisible(true);
		
		if(building == null) {
			if(ressources[0] >= 5 && ressources[2] >= 5) {
				buildL.setEnabled(true);
			}
			else {
				buildL.setEnabled(false);
			}
		}
		else {
			buildL.setVisible(false);
			upgrade.setVisible(true);
		}
		
		repaint();
	}

	public void displayMountain(int[] ressources, Building building) {
		test.setVisible(false);
		
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		upgrade.setVisible(false);
		
		buildM.setVisible(true);
		
		if(building == null) { 
			if(ressources[0] >= 20 && ressources[2] >= 10) {
				buildM.setEnabled(true);
			}
			else {
				buildM.setEnabled(false);
			}
		}
		else {
			buildM.setVisible(false);
			upgrade.setVisible(true);
		}
		repaint();
	}

	public void displayWater(int[] ressources, Building building) {
		test.setVisible(false);
		
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		upgrade.setVisible(false);
		
		buildF.setVisible(true);
		
		if(building == null) {
			if(ressources[0] >= 5 && ressources[2] >= 7) {
				buildF.setEnabled(true);
			}
			else {
				buildF.setEnabled(false);
			}
		}
		else {
			buildF.setVisible(false);
			upgrade.setVisible(true);
		}
		
		repaint();
	}
}
