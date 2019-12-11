package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Building;

public class HudWPanel extends JPanel {
	private int nbGold = 75, nbStone = 0, nbWood = 50, nbFood = 20;
	
	private Image selected, selectedOver, fill;
	
	private int moral = 130;
	private int population = 0;
	private int populationMax = 0;
	
	private String buildingLevel = "";
	private String buildingPop = "";
	private String buildingName = "";
	
	
	private static Font font = new Font("San Serif", Font.PLAIN, 35);
	private static Color color = new Color(240,240,240);
	
	public HudWPanel() {
		super();
		
		setBackground(new Color(100,100,100));
		setPreferredSize(new Dimension(268, 610));
		
		try {
			selected = ImageIO.read(new File("Graphismes/Disabled.png"));
			selectedOver = ImageIO.read(new File("Graphismes/Disabled.png"));
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
			g.drawImage(selectedOver, 100, 285, this);
			
			g.drawString("Name: " + buildingName, 10, 375);
			g.drawString("Level: " + buildingLevel, 10, 404);
			g.drawString("Population: " + buildingPop, 10, 433);
		} catch (Exception e) {}
		
	}
	
	public void display(String img, String imgOver) {
		try {
			selected = ImageIO.read(new File("Graphismes/"+img));
			if(!imgOver.equals("null")) {
				selectedOver = ImageIO.read(new File("Graphismes/"+imgOver));
			}
			else {
				selectedOver = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void setBuilding(Building building) {
		if(building != null) {
			buildingLevel = ""+building.getLevel();
			buildingPop = ""+building.getPopulation();
			String name = (building.getClass().getName()).substring(6);
			buildingName = ""+name;
		}
		else {
			buildingLevel = "";
			buildingPop = "";
			buildingName = "";
		}
		repaint();
	}

	public void setMoral(int moral) {
		this.moral = moral;
		repaint();
	}
}
