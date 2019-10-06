package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class MenuPanel extends JPanel {

	private Controller controller;
	
	private BufferedImage background;
	private JButton game, about, exit;
	private JLabel version;
	
	private static Font font;
	private static Color buttonColor = new Color(150,150,150);
	private static Color textColor = new Color(230,230,230);
	private static Dimension buttonSize = new Dimension(200,50);
	
	public MenuPanel(Controller controller) {
		super(new GridBagLayout());
		
		this.controller = controller;
		
		this.setBackground(new Color(27,72,123));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10,30,10,30);
		
		game = new JButton("Nouvelle Partie");
		gbc.gridx = 0;
		gbc.gridy = 0;
		game.setFont(font);
		game.setBackground(buttonColor);
		game.setForeground(textColor);
		game.setPreferredSize(buttonSize);
		game.setFocusPainted(false);
		game.addActionListener(new ButtonL());
		add(game, gbc);
		
		about = new JButton("A Propos");
		gbc.gridx = 0;
		gbc.gridy = 1;
		about.setFont(font);
		about.setBackground(buttonColor);
		about.setForeground(textColor);
		about.setPreferredSize(buttonSize);
		about.setFocusPainted(false);
		about.addActionListener(new ButtonL()); 
		add(about, gbc);
		
		exit = new JButton("Quitter");
		gbc.gridx = 0;
		gbc.gridy = 2;
		exit.setFont(font);
		exit.setBackground(buttonColor);
		exit.setForeground(textColor);
		exit.setPreferredSize(buttonSize);
		exit.setFocusPainted(false);
		exit.addActionListener(new ButtonL());
		add(exit, gbc);
		
		version = new JLabel("Alpha 1.0");
		gbc.gridx = 1;
		gbc.gridy = 2;
		version.setFont(font);
		version.setForeground(textColor);
		add(version, gbc);
	}
	
	
	class ButtonL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(game))
				controller.newGame();
			else if(e.getSource().equals(about))
				controller.about();
			else
				controller.closeView();
		}
	}
}