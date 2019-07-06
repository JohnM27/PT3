package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class HudCPanel extends JPanel {
	private Controller controller;
	private JButton essai;
	
	public HudCPanel(Controller controller) {
		super();
		
		this.controller = controller;
		
		essai = new JButton("ça prend toute la zone ?");
		essai.setPreferredSize(new Dimension(1610,840));
		essai.setBackground(Color.green);
		
		add(essai);
	}
}
