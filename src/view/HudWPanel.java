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
	private int nbGold = 75, nbStone = 0, nbWood = 50, nbFood = 20;
	
	private Image selected, fill;
	
	private int moral = 50;
	private int population = 0;
	private int populationMax = 0;
	
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
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try {
			g.setFont(font);
			g.setColor(color);
			
			
			g.drawImage(ImageIO.read(new File("Graphismes/textTest.png")), 100, 5, this);
			
			
			g.drawImage(ImageIO.read(new File("Graphismes/Gold.png")), 5, 29, this);
			g.drawImage(ImageIO.read(new File("Graphismes/Food.png")), 139, 29, this);
			g.drawImage(ImageIO.read(new File("Graphismes/Wood.png")), 5, 100, this);
			g.drawImage(ImageIO.read(new File("Graphismes/Stone.png")), 139, 100, this);
			
			g.drawString("" + nbGold, 71, 74);
			g.drawString("" + nbFood, 205, 74);
			g.drawString("" + nbWood, 71, 145);
			g.drawString("" + nbStone, 205, 145);
			
			
			g.drawString("Moral", 10, 201);
			g.drawRect(108, 171, 150, 35);
			g.fillRect(108, 171, moral, 35);
			
			g.drawString("Pop.", 10, 246);
			g.drawString( population + " / " + populationMax, 80, 246);
			
			
			g.drawImage(ImageIO.read(new File("Graphismes/textTest.png")), 100, 256, this);
			g.drawImage(selected, 100, 285, this);
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

	public void setPopulationMax(int populationMax) {
		this.populationMax = populationMax;
		repaint();
	}

	public void setPopulation(int population) {
		this.population = population;
		repaint();
	}

	public void setRessources(int[] ressources) {
		nbGold = ressources[0];
		nbStone = ressources[3]; 
		nbWood = ressources[2];
		nbFood = ressources[1];
		repaint();
	}
}
