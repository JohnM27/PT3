package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class HudCPanel extends JPanel {
	private Controller controller;
	
	private Noise n = new Noise();
	private Image grass_1, grass_2, grass_3, grass_4;
	private Image forest_1, forest_2, forest_3, forest_4, forest_5;
	private Image water;
	private Image mountain_1, mountain_2;
	
	private Image[][] map = new Image[18][10];
	
	
	public HudCPanel(Controller controller) {
		super();
		
		this.controller = controller;
		/*
		essai = new JButton("ça prend toute la zone ?");
		essai.setPreferredSize(new Dimension(1098,610));
		essai.setBackground(Color.green);
		
		add(essai);
		*/

		this.addMouseListener(new Mouse());
		this.setPreferredSize(new Dimension(1098, 610));
		
		try {
			water = ImageIO.read(new File("img/water.png"));
			mountain_1 = ImageIO.read(new File("img/Mountain_1.png"));
			mountain_2 = ImageIO.read(new File("img/Mountain_2.png"));
			grass_1 = ImageIO.read(new File("img/Grass_1.png"));
			grass_2 = ImageIO.read(new File("img/Grass_2.png"));
			grass_3 = ImageIO.read(new File("img/Grass_3.png"));
			grass_4 = ImageIO.read(new File("img/Grass_4.png"));
			forest_1 = ImageIO.read(new File("img/Forest_1.png"));
			forest_2 = ImageIO.read(new File("img/Forest_2.png"));
			forest_3 = ImageIO.read(new File("img/Forest_3.png"));
			forest_4 = ImageIO.read(new File("img/Forest_4.png"));
			forest_5 = ImageIO.read(new File("img/Forest_5.png"));
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		genererMap();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < 1098; i = i+61) {
			for(int j = 0; j < 610; j = j+61) {
				g.drawImage(map[i/61][j/61], i, j, this);
			}
		}
	}
	
	public void genererMap() {
		int valeur;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) { 
				valeur = (int) (n.creerNoise(i*61, j*61, 250)*40);
				if(valeur <= -10) {
					map[i][j] = water;
				}
				else if(valeur > -10 && valeur <= -1) {
					double r = Math.random();
					if(r <= 0.3) {
						map[i][j] = grass_1;
					}
					else if(r > 0.3 && r <= 0.6) {
						map[i][j] = grass_2;
					}
					else if(r > 0.6 && r <= 0.8) {
						map[i][j] = grass_3;
					}
					else {
						map[i][j] = grass_4;
					}
				}
				else if(valeur > -1 && valeur <= 6) {
					double r = Math.random();
					if(r <= 0.2) {
						map[i][j] = forest_1;
					}
					else if(r <= 0.4) {
						map[i][j] = forest_2;
					}
					else if(r <= 0.6) {
						map[i][j] = forest_3;
					}
					else if(r <= 0.8) {
						map[i][j] = forest_4;
					}
					else {
						map[i][j] = forest_5;
					}
				}
				else {
					double r = Math.random();
					if(r <= 0.5) {
						map[i][j] = mountain_1;
					}
					else {
						map[i][j] = mountain_2;
					}
				}
			}
		}
	}	
	
	class Mouse extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println("Coordonnées:");
			System.out.println(x);
			System.out.println(x/61);
			System.out.println(y);
			System.out.println(y/61);
			}
	}
}
