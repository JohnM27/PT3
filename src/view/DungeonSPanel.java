package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class DungeonSPanel extends JPanel {
	
	private Controller controller;
	
	private GridBagConstraints c = new GridBagConstraints();
	
	private JButton changeView;
	private JButton help;
	private JButton test;
	
	public DungeonSPanel(Controller controller) {
		super(new GridBagLayout());
		
		changeView = new JButton("Dungeon Change");
		changeView.addActionListener(controller);
		changeView.setPreferredSize(new Dimension(268,100));
		c.gridx = 0;
		c.gridy = 0;
		add(changeView, c);
		
		help = new JButton("Help");
		help.setPreferredSize(new Dimension(268,58));
		c.gridx = 0;
		c.gridy = 1;
		add(help, c);
		
		test = new JButton("TEST");
		test.setPreferredSize(new Dimension(1098,158));
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 2;
		add(test, c);
	}
}
