package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class HudSCPanel extends JPanel {
	private Controller controller;
	int typeCase = 1000;
	 
	private JLabel label1;
	private JButton buy, selected, test;
	
	 
	public HudSCPanel(Controller controller) {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		 
		this.controller = controller;
		
		setBackground(new Color(120,120,120));

 		label1 = new JLabel("SELECTED");
 		gbc.insets = new Insets(20,0,0,0);
 		gbc.gridx = 0;
 		gbc.gridy = 0;
 		add(label1, gbc);
 		
 		selected = new JButton();
		selected.setPreferredSize(new Dimension(61,61));
		selected.setBorderPainted(false);
		selected.setEnabled(false);
		gbc.insets = new Insets(20,20,20,20);
		gbc.gridx = 0;
 		gbc.gridy = 1;
 		add(selected, gbc);

 		buy = new JButton("BUY");
 		buy.setPreferredSize(new Dimension(831,158));
 		buy.addActionListener(controller);
 		buy.setVisible(false);
 		gbc.insets = new Insets(0,0,0,0);
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(buy, gbc);
 		
 		test = new JButton("CE BOUTON EST A CHANGER");
 		test.setPreferredSize(new Dimension(831,158));
 		gbc.gridx = 1;
 		gbc.gridy = 0;
 		gbc.gridheight = 2;
 		add(test, gbc);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image borderL = null;
		try {
			borderL = ImageIO.read(new File("Graphismes/BorderSL.png"));
		} catch (Exception e) {}
		g.drawImage(borderL, 0, 0, this);		
	}
		
	public void display(Image img) {
		test.setVisible(false);
		
		buy.setVisible(true);
		
		selected.setEnabled(true);
		
		selected.setIcon(new ImageIcon(img));
		
		repaint();
	}
	
	public void done() {
		test.setVisible(true);
		
		buy.setVisible(false);
		
		selected.setEnabled(false);
		
		selected.setIcon(null);
		
		repaint();
	}
}
