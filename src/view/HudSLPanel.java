package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HudSLPanel extends JPanel {
	/*
	private JLabel or, pierre, bois, nourriture;
	private int nbOr = 0, nbPierre = 0, nbBois = 0, nbNourriture = 0;
	
	private static Font font = new Font("San Serif", Font.PLAIN, 20);
	
	GridBagConstraints c = new GridBagConstraints();
	
	public HudSLPanel() {
		super(new GridBagLayout());
		this.setPreferredSize(new Dimension(268, 158));
		c.insets = new Insets(10, 10, 5, 10);
		
		or = new JLabel("Or: " + nbOr);
		or.setFont(font);
		c.gridx = 0;
		c.gridy = 0;
		add(or, c);
		
		c.insets = new Insets(5, 10, 5, 10);
		
		pierre = new JLabel("Pierre: " + nbPierre);
		pierre.setFont(font);
		c.gridx = 0;
		c.gridy = 1;
		add(pierre, c);
		
		bois = new JLabel("Bois: " + nbBois);
		bois.setFont(font);
		c.gridx = 0;
		c.gridy = 2;
		add(bois, c);
		
		c.insets = new Insets(5, 10, 10, 10);
		
		nourriture = new JLabel("Nourriture: " + nbNourriture);
		nourriture.setFont(font);
		c.gridx = 0;
		c.gridy = 3;
		add(nourriture, c);
	}*/
	
	GridBagConstraints c = new GridBagConstraints();
	
	public HudSLPanel() {
		super(new GridBagLayout());
		this.setPreferredSize(new Dimension(268, 158));
		
		JButton changeView = new JButton("Change View");
		changeView.setPreferredSize(new Dimension(268,100));
		c.gridx = 0;
		c.gridy = 0;
		add(changeView, c);
		
		JButton help = new JButton("Help");
		help.setPreferredSize(new Dimension(268,58));
		c.gridy = 1;
		add(help, c);
	}
}
