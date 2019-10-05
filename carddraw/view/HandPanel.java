package view;

import java.awt.Color;
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

import control.CardController;

@SuppressWarnings("serial")
public class HandPanel extends JPanel {
	
	private CardController controller;
	
	private JLabel textHand;
	private JButton submit4, submit6;
	
	private static Font font = new Font("Stencil", Font.PLAIN, 24);
	private static Dimension buttonSize = new Dimension(200,50);
	private static Color buttonColor = new Color(50,110,50);
	private static Color textColor = new Color(230,230,230);

	
	public HandPanel(CardController controller) {
		super(new GridBagLayout());
		
		this.controller = controller;
		
		this.setBackground(new Color(10,50,10));
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10,10,10,10);
		
		textHand = new JLabel("Nombre de cartes dans la main:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		textHand.setFont(font);
		textHand.setForeground(textColor);
		add(textHand, gbc);
		
		submit4 = new JButton("4");
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		submit4.setFont(font);
		submit4.setBackground(buttonColor);
		submit4.setForeground(textColor);
		submit4.setPreferredSize(buttonSize);
		submit4.setFocusPainted(false);
		submit4.addActionListener(new ButtonL());
		add(submit4, gbc);
		
		submit6 = new JButton("6");
		gbc.gridx = 1;
		submit6.setFont(font);
		submit6.setBackground(buttonColor);
		submit6.setForeground(textColor);
		submit6.setPreferredSize(buttonSize);
		submit6.setFocusPainted(false);
		submit6.addActionListener(new ButtonL());
		add(submit6, gbc);
	}
	

	class ButtonL implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(submit4))
				controller.setNbCard(4);
			else
				controller.setNbCard(6);
			
		}
	}
}