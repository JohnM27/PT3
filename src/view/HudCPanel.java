package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class HudCPanel extends JPanel {

	private Image[][] img = new Image[10][18];
	private Image[][] imgOver = new Image[10][18];
	private boolean[][] selected = new boolean[10][18];
	private static Image imgSelected = null;
	//private int[] oldCoord = {0,0};
	
	public HudCPanel(Controller controller) {
		super();
		
		this.addMouseListener(controller);
		this.setPreferredSize(new Dimension(1098, 610));
		
		try {
			imgSelected = ImageIO.read(new File("Graphismes/Selected.png"));
		} catch (Exception e) {}

		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 18; j++)
				selected[i][j] = false;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < 610; i = i+61) {
			for(int j = 0; j < 1098; j = j+61) {
				g.drawImage(img[i/61][j/61], j, i, this);
				
				if(imgOver[i/61][j/61] != null) {
					g.drawImage(imgOver[i/61][j/61], j, i, this);
				}
				
				if(selected[i/61][j/61] == true) {
					g.drawImage(imgSelected, j, i, this);
				}
			}
		}
		repaint();
	}
	
	public void mapGenerated(String[][] img, String[][] imgOver) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 18; j++) {
				try {
					this.img[i][j] = ImageIO.read(new File("Graphismes/"+img[i][j]));
					this.imgOver[i][j] = ImageIO.read(new File("Graphismes/"+imgOver[i][j]));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		repaint();
	}
	
	public void fogOff(int i, int j) {
		this.imgOver[i][j] = null;
		repaint();
	}
	
	public void buildingOn(int i, int j, String image) {
		try {
			this.imgOver[i][j] = ImageIO.read(new File("Graphismes/"+image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}

	public void selected(int[] coord) {		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 18; j++)
				selected[i][j] = false;
		
		selected[coord[0]][coord[1]] = true;
		repaint();
	}
}
