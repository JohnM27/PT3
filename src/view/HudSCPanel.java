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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import model.Building;

public class HudSCPanel extends JPanel {
	
	private Controller controller;
	
	private JButton buy, buildH, buildF, buildL, buildM, buildC, buildFarm, build1, build2, upgrade;
	
	
	public HudSCPanel(Controller controller) {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		 
		this.controller = controller;
		
		setBackground(new Color(100,100,100));

		
 		buy = new JButton("BUY");
 		buy.setPreferredSize(new Dimension(892,118));
 		buy.addActionListener(controller);
 		buy.setVisible(false);
 		gbc.insets = new Insets(20,20,20,20);
 		gbc.gridx = 0;
 		gbc.gridy = 0;
 		add(buy, gbc);
 		
 		
		upgrade = new JButton("UPGRADE");
 		upgrade.setPreferredSize(new Dimension(922,148));
 		upgrade.addActionListener(controller);
 		upgrade.setVisible(false);
 		gbc.gridx = 1;
		gbc.gridheight = 2;
 		add(upgrade, gbc);
		
		
 		buildC = new JButton("BUILD City Hall");
 		buildC.setPreferredSize(new Dimension(892,118));
 		buildC.addActionListener(controller);
 		buildC.setVisible(false);
 		gbc.gridx = 0;
 		gbc.gridy = 0;
 		add(buildC, gbc);
 		
 		
 		buildH = new JButton("BUILD House");
 		buildH.setPreferredSize(new Dimension(436,61));
 		buildH.addActionListener(controller);
 		buildH.setVisible(false);
 		gbc.insets = new Insets(10,20,8,10);
 		gbc.gridx = 0;
 		gbc.gridy = 0;
 		add(buildH, gbc);
 		
 		
 		buildFarm = new JButton("BUILD Farm");
 		buildFarm.setPreferredSize(new Dimension(436,61));
 		buildFarm.addActionListener(controller);
 		buildFarm.setVisible(false);
 		gbc.insets = new Insets(8,20,10,10);
 		gbc.gridx = 0;
 		gbc.gridy = 1;
 		add(buildFarm, gbc);
 		
 		
 		build1 = new JButton("BUILD");
 		build1.setPreferredSize(new Dimension(436,61));
 		//buildFarm.addActionListener(controller);
 		build1.setVisible(false);
 		gbc.insets = new Insets(10,10,8,20);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		add(build1, gbc);
 		
 		
 		build2 = new JButton("BUILD");
 		build2.setPreferredSize(new Dimension(436,61));
 		//buildFarm.addActionListener(controller);
 		build2.setVisible(false);
 		gbc.insets = new Insets(8,10,10,20);
 		gbc.gridx = 1;
 		gbc.gridy = 1;
 		add(build2, gbc);
 		
 		
 		buildF = new JButton("BUILD Fishing");
 		buildF.setPreferredSize(new Dimension(892,118));
 		buildF.addActionListener(controller);
 		buildF.setVisible(false);
 		gbc.insets = new Insets(20,20,20,20);
 		gbc.gridx = 0;
 		gbc.gridy = 0;
 		add(buildF, gbc);
 		
 		
 		buildL = new JButton("BUILD Logging");
 		buildL.setPreferredSize(new Dimension(892,118));
 		buildL.addActionListener(controller);
 		buildL.setVisible(false);
 		gbc.insets = new Insets(20,20,20,20);
 		gbc.gridx = 0;
 		gbc.gridy = 0;
 		add(buildL, gbc);
 		
 		
 		buildM = new JButton("BUILD Mine");
 		buildM.setPreferredSize(new Dimension(892,118));
 		buildM.addActionListener(controller);
 		buildM.setVisible(false);
 		gbc.insets = new Insets(20,20,20,20);
 		gbc.gridx = 0;
 		gbc.gridy = 0;
 		add(buildM, gbc);
		
		
		buildC = new JButton("BUILD City Hall");
 		buildC.setPreferredSize(new Dimension(831,158));
 		buildC.addActionListener(controller);
 		buildC.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
		gbc.gridheight = 2;
 		add(buildC, gbc);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image borderL = null, textTest = null;
		try {
			borderL = ImageIO.read(new File("Graphismes/BorderSL.png"));
		} catch (Exception e) {}
		g.drawImage(borderL, 0, 0, this);
	}
		
	public void display(boolean adjacent, String typeCase, boolean cityHall, int[] ressources) {
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		build1.setVisible(false);
		build2.setVisible(false);
		upgrade.setVisible(false);
		
		if(((controller.isFirstBuy() && typeCase.equals("model.Plain")) || (adjacent && cityHall)) && ressources[0] >= 6) {
			buy.setEnabled(true);
		}
		else {
			buy.setEnabled(false);
		}
		
		buy.setVisible(true);
		
		repaint();
	}
	
	//Pas utilisÃ© mais plus peut-Ãªtre oui
	/*
	public void done() {
		test.setVisible(true);
		
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		
		selected.setEnabled(false);
		
		selected.setIcon(null);
		
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
		selected.setEnabled(false);
		
		upgrade.setVisible(true);
		upgrade.setEnabled(true);
		selected.setIcon(null);
		
		repaint();
	}	
	
	public void displayPlainCityHall(Image img, int[] ressources, boolean build) {
		buy.setVisible(false);
		
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildH.setVisible(false);
		buildFarm.setVisible(false);
		build1.setVisible(false);
		build2.setVisible(false);
		upgrade.setVisible(false);
		
		buildC.setVisible(true);
		
		if(building == null) {
			if(ressources[0] >= 50 && ressources[2] >= 30) {
				buildC.setEnabled(true);
			}
			else {
				buildC.setEnabled(false);
			}
		if(!build && ressources[0] >= 50 && ressources[2] >= 30) {
			buildC.setEnabled(true);
		}
		else {
			buildC.setVisible(false);
			upgrade.setVisible(true);
			buildC.setEnabled(false);
		}
		repaint();
	}

	public void displayPlain(Image img, int[] ressources, boolean build) {
		buy.setVisible(false);
		
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		upgrade.setVisible(false);
		
		buildH.setVisible(true);
		buildFarm.setVisible(true);
		build1.setVisible(true);
		build2.setVisible(true);
		
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
		else {
			buildH.setVisible(false);
			buildFarm.setVisible(false);
			upgrade.setVisible(true);
			buildH.setEnabled(false);
		}
		repaint();
	}

	public void displayForest(Image img, int[] ressources, boolean build) {
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		build1.setVisible(false);
		build2.setVisible(false);
		upgrade.setVisible(false);
		
		buildL.setVisible(true);
		
		if(building == null) {
			if(ressources[0] >= 5 && ressources[2] >= 5) {
				buildL.setEnabled(true);
			}
			else {
				buildL.setEnabled(false);
			}
		else {
			buildL.setVisible(false);
			upgrade.setVisible(true);
			buildL.setEnabled(false);
		}
		repaint();
	}

	public void displayMountain(Image img, int[] ressources, boolean build) {
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		build1.setVisible(false);
		build2.setVisible(false);
		upgrade.setVisible(false);
		
		buildM.setVisible(true);
		
		if(building == null) { 
			if(ressources[0] >= 20 && ressources[2] >= 10) {
				buildM.setEnabled(true);
			}
			else {
				buildM.setEnabled(false);
			}
		else {
			buildM.setVisible(false);
			upgrade.setVisible(true);
			buildM.setEnabled(false);
		}
		repaint();
	}

	public void displayWater(Image img, int[] ressources, boolean build) {
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		build1.setVisible(false);
		build2.setVisible(false);
		upgrade.setVisible(false);
		
		buildF.setVisible(true);
		
		if(building == null) {
			if(ressources[0] >= 5 && ressources[2] >= 7) {
				buildF.setEnabled(true);
			}
			else {
				buildF.setEnabled(false);
			}
		else {
			buildF.setVisible(false);
			upgrade.setVisible(true);
			buildF.setEnabled(false);
		}
		repaint();
	}
}
