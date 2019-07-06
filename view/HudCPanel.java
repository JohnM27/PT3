package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class HudCPanel extends JPanel {
	private Controller controller;
	private JButton essai;
	
	public HudCPanel(Controller controller) {
		super();
		
		this.controller = controller;
		
		this.setPreferredSize(new Dimension(1500, 700));
		
		essai = new JButton("ça prend toute la zone ?");
		essai.setBackground(Color.green);
		
		add(essai);
	}
}
