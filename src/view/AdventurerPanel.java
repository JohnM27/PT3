package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdventurerPanel extends JPanel {

	private JLabel name, level, mission, health, moral, activity;
	private JLabel xp;
	
	private static Font font = new Font("Sans Serif", Font.PLAIN, 15);
	
	public AdventurerPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.setPreferredSize(new Dimension(255,79));
		this.setBackground(new Color(255,200,200));
		
		gbc.insets = new Insets(3,5,2,5);
		/*
		JButton icon = new JButton("");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		icon.setMinimumSize(new Dimension(60,60));
		icon.setBackground(new Color(255,100,100));
		//add(icon, gbc);*/
		
		name = new JLabel("Mathéo FAIVRE");
		name.setFont(font);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(name, gbc);
		
		
		activity = new JLabel("Disponible");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(activity, gbc);
		
		gbc.insets = new Insets(2,5,2,5);
		
		
		level = new JLabel("Level: " + 1);
		level.setFont(font);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(level, gbc);
		
		
		xp = new JLabel("XP: " + 100);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(xp, gbc);
		
		
		health = new JLabel("HP: " + 100);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(health, gbc);
		
		

	}
}
