package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;

public class HudSRPanel extends JPanel {
	private Controller controller;
	
	private JButton suivant, menu, quitter;
	private JLabel jour;
	
	private int nbJour;
		
	private static Dimension buttonSize = new Dimension(83,40);
	
	GridBagConstraints c = new GridBagConstraints();
	
	public HudSRPanel(Controller controller, int nbJour) {
		super(new GridBagLayout());
		
		this.controller = controller;
		this.nbJour = nbJour;
		
		//this.setPreferredSize(new Dimension(230, 240));
		//this.setPreferredSize(new Dimension(166, 158));
		c.fill = GridBagConstraints.BOTH;
		jour = new JLabel("Jour " + this.nbJour, SwingConstants.CENTER);
		jour.setFont(new Font("Sans Serif", Font.PLAIN, 28));
		c.insets = new Insets(13,5,13,5);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		add(jour, c);
		
		suivant = new JButton("Jour suivant");
		suivant.setPreferredSize(new Dimension(166,55));
		suivant.setFont(new Font("Sans Serif", Font.PLAIN, 24));
		suivant.addActionListener(new ButtonL());
		c.insets = new Insets(0,0,0,0);
		c.gridx = 0;
		c.gridy = 1;
		add(suivant, c);
		
		menu = new JButton("Menu");
		menu.setPreferredSize(buttonSize);
		menu.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		menu.addActionListener(new ButtonL());
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		add(menu, c);
		
		quitter = new JButton("Quitter");
		quitter.setPreferredSize(buttonSize);
		quitter.setFont(new Font("Sans Serif", Font.PLAIN, 16));
		quitter.addActionListener(new ButtonL());
		c.gridx = 1;
		c.gridy = 2;
		add(quitter, c);
	}
	
	public void setNbJour(int nbJour) {
		this.nbJour = nbJour;
		jour.setText("Jour " + nbJour);
	}
	
	
	
	class ButtonL implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(menu))
				controller.menu();
			else if(e.getSource().equals(quitter))
				controller.closeView();
			else if (e.getSource().equals(suivant))
				controller.notifyJourChanged(nbJour+1);
		}
	}
}
