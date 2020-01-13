package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;

@SuppressWarnings("serial")
public class EventPanel extends JPanel {

	private GridBagConstraints gbc;
	private Image image;
	private JLabel text1, text2;
	private JButton button1, button2, button3, button4;
	
	public EventPanel(Controller controller) {
		super(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 10, 5, 10);
		text1 = new JLabel("Titre", SwingConstants.CENTER);
		text1.setPreferredSize(new Dimension(380, 50));
		this.add(text1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(205, 10, 5, 10);
		text2 = new JLabel("Explication", SwingConstants.CENTER);
		this.add(text2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 10, 5, 10);
		button1 = new JButton("Nothing to do");
		button1.addActionListener(controller);
		button1.setPreferredSize(new Dimension(380, 50));
		this.add(button1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		button2 = new JButton("Nothing to do");
		button2.addActionListener(controller);
		button2.setPreferredSize(new Dimension(380, 50));
		this.add(button2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		button3 = new JButton("Nothing to do");
		button3.addActionListener(controller);
		button3.setPreferredSize(new Dimension(380, 50));
		this.add(button3, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		button4 = new JButton("Nothing to do");
		button4.addActionListener(controller);
		button4.setPreferredSize(new Dimension(380, 50));
		this.add(button4, gbc);
		
		try {                
			image = ImageIO.read(new File("Graphismes/Event.png"));
		} catch (IOException ex) {}
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 10, 55, this);           
    }
	
	public void event(int nbEvent, int foodLoose, int goldLoose) {
		if(nbEvent == 0) {
			text1.setText("Attack of bandits");
			text2.setText("You can try to stop here or not !");
			button1.setText("Stop them");
			button1.setActionCommand("StopBandits");
			button2.setText("Let them ("+goldLoose+" gold loose)");
			button2.setActionCommand("LetBandits");
			button3.setEnabled(false);
			button4.setEnabled(false);
		}
		else if(nbEvent == 1){
			text1.setText("Flesh food !");
			text2.setText("You can do nothing for that ! You loose "+foodLoose+" food");
			button1.setText("Exit");
			button1.setActionCommand("ExitEvent");
			button2.setEnabled(false);
			button3.setEnabled(false);
			button4.setEnabled(false);
		}
		else {
			text1.setText("Congratulations !");
			text2.setText("You gain 10 golds ! Because your inhabitance works hard !");
			button1.setText("Exit");
			button1.setActionCommand("ExitEvent");
			button2.setEnabled(false);
			button3.setEnabled(false);
			button4.setEnabled(false);
		}
	}

}
