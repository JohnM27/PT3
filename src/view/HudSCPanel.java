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

public class HudSCPanel extends JPanel {
	private Controller controller;
	
	//taille max = 922,148
	private JButton buy, buildH, buildF, buildL, buildM, buildC;
	
	 
	public HudSCPanel(Controller controller) {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		 
		this.controller = controller;
		
		setBackground(new Color(100,100,100));


 		gbc.insets = new Insets(5,5,5,5);
 		
 		buy = new JButton("BUY");
 		buy.setPreferredSize(new Dimension(922,148));
 		buy.addActionListener(controller);
 		buy.setVisible(false);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(buy, gbc);
 		
 		
 		buildH = new JButton("BUILD House");
 		buildH.setPreferredSize(new Dimension(831,158));
 		buildH.addActionListener(controller);
 		buildH.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(buildH, gbc);
 		
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
		} catch (Exception e) {}
		g.drawImage(borderL, 0, 0, this);
	}
		
	public void display(Image img, boolean adjacent, String typeCase, boolean cityHall) {		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		
		if((controller.isFirstBuy() && typeCase.equals("model.Plain")) || (adjacent && cityHall)) {
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
		
		selected.setEnabled(false);
		
		selected.setIcon(null);
		
		repaint();
	}*/
	
	public void displayPlainCityHall(Image img) {
		buy.setVisible(false);
		
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildH.setVisible(false);
		
		buildC.setVisible(true);
		
		repaint();
	}

	public void displayPlain(Image img) {
		buy.setVisible(false);
		
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		
		buildH.setVisible(true);
		
		repaint();
	}

	public void displayForest(Image img) {
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		
		buildL.setVisible(true);
		
		repaint();
	}

	public void displayMountain(Image img) {
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildF.setVisible(false);
		buildL.setVisible(false);
		buildC.setVisible(false);
		
		buildM.setVisible(true);
		
		repaint();
	}

	public void displayWater(Image img) {
		buy.setVisible(false);
		
		buildH.setVisible(false);
		buildL.setVisible(false);
		buildM.setVisible(false);
		buildC.setVisible(false);
		
		buildF.setVisible(true);
		
		repaint();
	}
}
