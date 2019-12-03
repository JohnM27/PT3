package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class DungeonWPanel extends JPanel {

	private Controller controller;
	
	private JButton test;
	
	public DungeonWPanel(Controller controller) {
		super(new GridLayout(1,0));
		
		test = new JButton("TEST");
		test.setPreferredSize(new Dimension(268, 610));
		add(test);
	}
}
