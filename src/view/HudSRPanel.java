package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;

@SuppressWarnings("serial")
public class HudSRPanel extends JPanel {
	
	private JButton next, save, exit;
	private JLabel day;
		
	private static Dimension buttonSize = new Dimension(83,40);
	
	GridBagConstraints c = new GridBagConstraints();
	
	public HudSRPanel(Controller controller) {
		super(new GridBagLayout());		
		
		c.fill = GridBagConstraints.BOTH;
		day = new JLabel("day 0", SwingConstants.CENTER);
		day.setFont(new Font("Sans Serif", Font.PLAIN, 28));
		c.insets = new Insets(13,5,13,5);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		add(day, c);
		
		next = new JButton("Next day");
		next.setPreferredSize(new Dimension(166,55));
		next.setFont(new Font("Sans Serif", Font.PLAIN, 24));
		next.addActionListener(controller);
		c.insets = new Insets(0,0,0,0);
		c.gridx = 0;
		c.gridy = 1;
		add(next, c);
		
		save = new JButton("Save");
		save.setPreferredSize(buttonSize);
		save.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		save.addActionListener(controller);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		add(save, c);
		
		exit = new JButton("Exit");
		exit.setPreferredSize(buttonSize);
		exit.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		exit.addActionListener(controller);
		c.gridx = 1;
		c.gridy = 2;
		add(exit, c);
	}
	
	public void setNbDay(int nbDay) {
		day.setText("day " + nbDay);
	}
}
