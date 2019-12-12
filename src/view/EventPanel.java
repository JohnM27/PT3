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
		button1 = new JButton("Choix 1");
		button1.setPreferredSize(new Dimension(380, 50));
		this.add(button1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		button2 = new JButton("Choix 2");
		button2.setPreferredSize(new Dimension(380, 50));
		this.add(button2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		button3 = new JButton("Choix 3");
		button3.setPreferredSize(new Dimension(380, 50));
		this.add(button3, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		button4 = new JButton("Choix 4");
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

}
