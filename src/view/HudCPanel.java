package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controller;

public class HudCPanel extends JPanel {
	private Controller controller;

	private Image[][] img;
	private Image[][] imgOver;
	private static Image imgSelected = null;
	private static Image imgDeselected = null;
	private int[] oldCoord = {0,0};
	
	public HudCPanel(Controller controller) {
		super();
		
		this.controller = controller;
		
		this.addMouseListener(controller);
		this.setPreferredSize(new Dimension(1098, 610));
		
		try {
			imgSelected = ImageIO.read(new File("Graphismes/Selected.png"));
			imgDeselected = ImageIO.read(new File("Graphismes/Territory.png"));
		} catch (Exception e) {}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < 610; i = i+61) {
			for(int j = 0; j < 1098; j = j+61) {
				g.drawImage(img[i/61][j/61], j, i, this);
				
				if(imgOver[i/61][j/61] != null) {
					g.drawImage(imgOver[i/61][j/61], j, i, this);
				}
			}
		}
	}
	
	public void mapGenerated(Image[][] img, Image[][] imgOver) {
		this.img = img;
		this.imgOver = imgOver;
	}
	
	public void fogOff(int i, int j) {
		this.imgOver[i][j] = null;
		repaint();
	}

	public void houseOn(int i, int j, Image image) {
		this.imgOver[i][j] = image;
		repaint();
	}

	public void fishingOn(int i, int j, Image image) {
		this.imgOver[i][j] = image;
		repaint();
	}
	
	public void loggingOn(int i, int j, Image image) {
		this.imgOver[i][j] = image;
		repaint();
	}
	
	public void mineOn(int i, int j, Image image) {
		this.imgOver[i][j] = image;
		repaint();
	}

	public void selected(int[] coord) {
		if(imgOver[oldCoord[0]][oldCoord[1]] != null) {
			this.imgOver[oldCoord[0]][oldCoord[1]] = imgDeselected;
		}
		
		this.imgOver[coord[0]][coord[1]] = imgSelected;
		oldCoord[0] = coord[0];
		oldCoord[1] = coord[1];
		repaint();
	}
}
