package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HudWPanel extends JPanel {
	/*
	private HudWUPanel HudWUPanel;
	private HudWDPanel HudWDPanel;
	
	public HudWPanel() {
		super(new BorderLayout());
		
		HudWUPanel = new HudWUPanel();
		add(HudWUPanel, BorderLayout.NORTH);
		
		HudWDPanel = new HudWDPanel();
		add(HudWDPanel, BorderLayout.CENTER);
	}
	*/
	private int nbGold = 0, nbStone = 0, nbWood = 0, nbFood = 0;
	
	private Image selected, fill;
	
	
	private static Font font = new Font("San Serif", Font.PLAIN, 35);
	private static Color color = new Color(240,240,240);
	
	GridBagConstraints c = new GridBagConstraints();
	
	public HudWPanel() {
		super(new GridBagLayout());
		
		setBackground(new Color(100,100,100));
		
		this.setPreferredSize(new Dimension(268, 610));
		
		try {
			selected = ImageIO.read(new File("Graphismes/Disabled.png"));
		} catch (Exception e) {}
		
		/*
 		selected = new JButton();
		selected.setPreferredSize(new Dimension(61,61));
		selected.setBorderPainted(false);
		selected.setEnabled(false);
		c.insets = new Insets(20,125,20,20);
		c.gridx = 0;
 		c.gridy = 0;
 		//add(selected, c);
 		
 		
 		fill = new JButton();
 		fill.setPreferredSize(new Dimension(268,200));
 		c.insets = new Insets(0,0,0,0);
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 4;
 		//add(fill, c);
 		*/
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			g.setFont(font);
			g.setColor(color);
			
			
			g.drawImage(ImageIO.read(new File("Graphismes/Gold.png")), 5, 5, this);
			g.drawImage(ImageIO.read(new File("Graphismes/Food.png")), 139, 5, this);
			g.drawImage(ImageIO.read(new File("Graphismes/Wood.png")), 5, 76, this);
			g.drawImage(ImageIO.read(new File("Graphismes/Stone.png")), 139, 76, this);
			
			g.drawString("" + nbGold, 71, 50);
			g.drawString("" + nbFood, 205, 50);
			g.drawString("" + nbWood, 71, 121);
			g.drawString("" + nbStone, 205, 121);
			
			
			g.drawImage(ImageIO.read(new File("Graphismes/textTest.png")), 25, 172, this);
			g.drawImage(selected, 202, 152, this);
		} catch (Exception e) {}
		
	}
	
	public void display(Image img) {
		selected = img;
		
		repaint();
	}
	
	//Pas utilisé mais plus tard oui normalement
	public void done() {
		//selected.setIcon(null);
		
		repaint();
	}
}
