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

@SuppressWarnings("serial")
public class HudSCPanel extends JPanel {
	
	private JButton buy, buildH, buildF, buildL, buildM, buildC, buildFarm, build1, build2, upgrade;
	
	
	public HudSCPanel(Controller controller) {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
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
 		upgrade.setPreferredSize(new Dimension(892,118));
 		upgrade.addActionListener(controller);
 		upgrade.setVisible(false);
 		gbc.gridx = 0;
 		gbc.gridy = 0;
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
 		build1.addActionListener(controller);
 		build1.setVisible(false);
 		gbc.insets = new Insets(10,10,8,20);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		add(build1, gbc);
 		
 		
 		build2 = new JButton("BUILD");
 		build2.setPreferredSize(new Dimension(436,61));
 		build2.addActionListener(controller);
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
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image borderL = null;
		try {
			borderL = ImageIO.read(new File("Graphismes/BorderSL.png"));
		} catch (Exception e) {}
		g.drawImage(borderL, 0, 0, this);
	}
	
	public void setVisibleFalseAll() {
		buy.setVisible(false);
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		buildFarm.setVisible(false);
		build1.setVisible(false);
		build2.setVisible(false);
		upgrade.setVisible(false);
	}
	
		
	public void display(boolean adjacent, String typeCase, boolean firstBuy, boolean cityHall, int[] ressources) {
		
		setVisibleFalseAll();
		
		if(((firstBuy && typeCase.equals("model.Plain")) || (adjacent && cityHall)) && ressources[0] >= 6) {
			buy.setEnabled(true);
		}
		else {
			buy.setEnabled(false);
		}
		
		buy.setVisible(true);
		
		repaint();
	}
	
	//Pas utilisÃƒÂ© mais plus peut-ÃƒÂªtre oui
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
		
		setVisibleFalseAll();
		
		upgrade.setVisible(true);
		upgrade.setEnabled(true);
		
		repaint();
	}	
	
	public void displayPlainCityHall(int[] ressources, Building building) {
		
		setVisibleFalseAll();
		
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
			displayUpgrade();
		}
		repaint();
	}

	public void displayPlain(int[] ressources, Building building) {
		
		setVisibleFalseAll();
		
		
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
		}
		else {
			displayUpgrade();
		}
		repaint();
	}

	public void displayForest(int[] ressources, Building building) {
		
		setVisibleFalseAll();
		
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
			displayUpgrade();
		}
		repaint();
	}

	public void displayMountain(int[] ressources, Building building) {
		
		setVisibleFalseAll();
		
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
			displayUpgrade();
		}
		repaint();
	}

	public void displayWater(int[] ressources, Building building) {
		
		setVisibleFalseAll();
		
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
			displayUpgrade();
		}
		repaint();
	}
}
