package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdventurerPanel extends JPanel {

	private JLabel name, level, mission, health, moral, activity;
	
	public AdventurerPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.setPreferredSize(new Dimension(268,100));
		
		gbc.insets = new Insets(5,5,5,5);
		
		JButton icon = new JButton("");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		icon.setMinimumSize(new Dimension(60,60));
		icon.setBackground(new Color(255,100,100));
		add(icon, gbc);
		
		name = new JLabel("Blablabla blablabla");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		add(name, gbc);
		
		level = new JLabel("Niv: " + 1);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(level, gbc);
		
		mission = new JLabel("Nb Mission: " + 10);
		gbc.gridx = 2;
		gbc.gridy = 1;
		add(mission, gbc);
		
		health = new JLabel("PV: " + 100);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(health, gbc);
		
		moral = new JLabel("Moral: " + 100);
		gbc.gridx = 2;
		gbc.gridy = 2;
		add(moral, gbc);
		
		activity = new JLabel("Disponible");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		add(activity, gbc);
	}
}
